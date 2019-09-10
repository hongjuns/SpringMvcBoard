package org.zerock.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace ="org.zerock.mapper.UserMapper";	
	

	@Override
	public UserVO login(UserVO dto) throws Exception {
		
		return session.selectOne(namespace +".login", dto);
	}
	
	@Override
	public boolean SnsLoginCheck(String id) throws Exception {
		
		String token = session.selectOne(namespace +".SnsLoginCheck", id);
		 System.out.println("token : " + token);
		return (token == null) ? false : true;
		
	}
	
	@Override
	public boolean MemberLoginCheck(UserVO dto) throws Exception {
		
		String token = session.selectOne(namespace +".login", dto);
		return (token == null) ? false : true;
		
	}
	
	@Override
	public UserVO Viewlogin(String code) throws Exception {
		
		return session.selectOne(namespace +".SnsLoginView", code);
		
	}


	  @Override
	  public void SnsLoginInsert(String uid,String name, String token) throws Exception {
		  
		   Map<String, Object> paramMap = new HashMap<String, Object>();
		    
		    paramMap.put("uid", uid);
		    paramMap.put("name", name);
		    paramMap.put("token", token);
		    
	    session.insert(namespace + ".SnsLoginInsert", paramMap);
	  }
	  
	@Override  
	public UserVO FirstSnsLoginView()throws Exception {
		return session.selectOne(namespace +".FirstSnsLoginView");
	}
}
