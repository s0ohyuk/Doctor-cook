package com.user.dao;

import org.springframework.stereotype.Repository;

import com.user.domain.UserCommand;

@Repository
public interface UserDao {
	
	//회원가입 
	public void signUp(UserCommand userCommand);
	
	//id중복체크
	public int idCheck(String mem_id);
	
	//logIn
	public UserCommand logIn(UserCommand userCommand);
    
//	//회원정보보기 	
//	public UserCommand userInfo(String mem_id);
//	
	//회원정보수정 
	public void modifyUser(UserCommand User);
//	
//	//비밀번호변경
//	public void modifypwd(UserCommand chgpwd);
}
