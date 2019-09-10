package org.zerock.service;

import javax.servlet.http.HttpSession;

import org.zerock.domain.BoardVO;
import org.zerock.domain.UserVO;

public interface UserService {
	
	 public UserVO login(UserVO dto) throws Exception;
	 
	 public boolean SnsLoginCheck(String code) throws Exception;

	 public UserVO Viewlogin(String code)throws Exception;
	 
	 public void SnsLoginInsert(String uid,String name, String token) throws Exception;
	 
	 public UserVO FristViewlogin(String uid,String name, String token )throws Exception;
	 
	 
}

