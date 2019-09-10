package org.zerock.persistence;

import javax.servlet.http.HttpSession;

import org.zerock.domain.BoardVO;
import org.zerock.domain.UserVO;

public interface UserDAO {

	
	public UserVO login(UserVO dto)throws Exception;
	
	public boolean SnsLoginCheck (String code) throws Exception;
	
	public boolean MemberLoginCheck (UserVO dto) throws Exception;
	
	public UserVO Viewlogin(String code)throws Exception;
	
	public void SnsLoginInsert(String uid,String name, String token) throws Exception;
	
	public UserVO FirstSnsLoginView()throws Exception;
	
}
