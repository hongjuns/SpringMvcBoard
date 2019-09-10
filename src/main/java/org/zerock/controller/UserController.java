package org.zerock.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.api.kakao_restapi;
import org.zerock.domain.UserVO;
import org.zerock.service.BoardService;
import org.zerock.service.UserService;

import com.github.scribejava.core.model.OAuth2AccessToken;
import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.api.plus.PlusOperations;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;

@Controller
@RequestMapping("/login_project/*")
public class UserController {

	  private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	  
	   /*구글*/
	  @Inject
	  private GoogleConnectionFactory googleConnectionFactory;
	  @Inject
	  private OAuth2Parameters googleOAuth2Parameters;
	  
	  @Inject
	  private UserService service;

	  public final static String K_CLIENT_ID = "eaa54710ea7f74dcd5f9cac757da0738";
	  public final static String K_REDIRECT_URI = "http://localhost:8080/login_project/kakaoauth";
	  
	  public String getAuthorizationUrl(HttpSession session) {

	        String kakaoUrl = "https://kauth.kakao.com/oauth/authorize?"
	                + "client_id=" + K_CLIENT_ID + "&redirect_uri="
	                + K_REDIRECT_URI + "&response_type=code";
	        return kakaoUrl;
	    }

	  
	  @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public String loginGET() {

		  return "member/login";
	  }
	  
	   /*카카오톡 login */
	   @RequestMapping(value = "/kakalogin", method = RequestMethod.GET)
	   public String kakalogin(Model model,HttpSession session){

	        String kakaoUrl = getAuthorizationUrl(session);

	        /* 생성한 인증 URL을 View로 전달 */
	        model.addAttribute("kakao_url", kakaoUrl);

	        return"member/kaka";
	    }
	    
	   /*카카오톡 인증 */
	    @RequestMapping(value = "/kakaoauth", produces = "application/json")
	    public String kakaoLogin(@RequestParam("code") String code, Model model, HttpSession session)  throws Exception{


	        kakao_restapi kakao_restapi = new kakao_restapi ();
	        JsonNode userInfo = kakao_restapi.getKakaoUserInfo(code);


	        String id = userInfo.get("id").toString();
	        String image = userInfo.get("properties").get("profile_image").toString();
	        String nickname = userInfo.get("properties").get("nickname").toString();
	        
	        
	        System.out.println(userInfo);
	   	 	System.out.println("kakaoauth 시작");
	   	 	
	   	 	boolean result = service.SnsLoginCheck(id);
	        
	        if (result) {
	        	
	        	UserVO uservo = service.Viewlogin(id);
	        	
	        	session.setAttribute("getUserNo", uservo.getUno());
	        	session.setAttribute("getUid", uservo.getUid());
	        	session.setAttribute("getName", uservo.getName());
	        	
	        }else {

	        	UserVO uservo = service.FristViewlogin(id,nickname,code);
	        	
	        	session.setAttribute("getUserNo", uservo.getUno());
	        	session.setAttribute("getUid", uservo.getUid());
	        	session.setAttribute("getName", uservo.getName());
	        	
	        }
	        return "redirect:/";
	    }
	    
	    // 구글 로그인 요청
	    @RequestMapping(value = "/gologin", method = { RequestMethod.GET})
	    public String login(Model model, HttpSession session) {

	        /* 구글code 발행 */
	        OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
	        String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);

	        System.out.println("구글:" + url);

	        model.addAttribute("google_url", url);

	        /* 생성한 인증 URL을 View로 전달 */
	        return "member/google";
	    }

	    
	    // 구글 Callback호출 메소드
	    @RequestMapping(value = "/oauth2callback", method = { RequestMethod.GET, RequestMethod.POST })
	    public String googleCallback(Model model,@RequestParam String code,HttpSession session) throws Exception {
	        System.out.println("여기는 googleCallback");


	        OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
	        AccessGrant accessGrant = oauthOperations.exchangeForAccess(code, googleOAuth2Parameters.getRedirectUri(), null);
	        String accessToken = accessGrant.getAccessToken();
	        Long expireTime = accessGrant.getExpireTime();
	        if (expireTime != null && expireTime < System.currentTimeMillis())
	        {
	            accessToken = accessGrant.getRefreshToken();

	        }
	        Connection<Google> connection = googleConnectionFactory.createConnection(accessGrant);
	        Google google = connection == null ? new GoogleTemplate(accessToken) : connection.getApi();

	        PlusOperations plusOperations = google.plusOperations();
	        String id = google.getAccessToken();
	        Person person = plusOperations.getGoogleProfile();


	        model.addAttribute("email", person.getEmails());
	        model.addAttribute("birtday", person.getBirthday());
	        
	        System.out.println(person.getId());
	        boolean result = service.SnsLoginCheck(person.getId());
	        
	        if (result) {
	        	
	        	UserVO uservo = service.Viewlogin(id);
	        	
	        	session.setAttribute("getUserNo", uservo.getUno());
	        	session.setAttribute("getUid", uservo.getUid());
	        	session.setAttribute("getName", uservo.getName());
	        	
	        }else {

	        	UserVO uservo = service.FristViewlogin(person.getId(),person.getDisplayName(),id);
	        	
	        	session.setAttribute("getUserNo", uservo.getUno());
	        	session.setAttribute("getUid", uservo.getUid());
	        	session.setAttribute("getName", uservo.getName());
	        	
	        }

	        return "redirect:/";
	    }


}
