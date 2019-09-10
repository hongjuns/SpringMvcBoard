package org.zerock.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardVO;
import org.zerock.domain.UserVO;
import org.zerock.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	  @Inject
	  private UserDAO dao;

	  @Override
	  public UserVO login(UserVO dto) throws Exception {

	    return dao.login(dto);
	  }
	  
	  @Override
	  public boolean SnsLoginCheck(String id) throws Exception {

		 
		 return dao.SnsLoginCheck(id);
	  }
	  
	  @Override
	  public UserVO Viewlogin(String code) throws Exception {

	    return dao.Viewlogin(code);
	  }
	  
	  @Override
	 public void SnsLoginInsert(String uid,String name, String token) throws Exception {
		    dao.SnsLoginInsert(uid,name,token);
		    
	 }
	  
	  
	  @Transactional
	  @Override
	  public UserVO FristViewlogin(String uid,String name, String token) throws Exception {
		  dao.SnsLoginInsert(uid,name,token);
		  return dao.FirstSnsLoginView();  
			    
	 }

	
}
