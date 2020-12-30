package com.user.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.user.domain.UserCommand;

@Service("userDaoImpl")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	
	public void signUp(UserCommand userCommand) {
		// TODO Auto-generated method stub
		getSqlSession().insert("signUp", userCommand);
	}

	public int idCheck(String mem_id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("UserMapper.idCheck",mem_id);
	}

	public UserCommand logIn(UserCommand userCommand) {
		// TODO Auto-generated method stub
		System.out.println("logindaoimpl호출");
		return (UserCommand)getSqlSession().selectOne("UserMapper.logIn",userCommand);
	}

//	public UserCommand userInfo(String mem_id) {
//		// TODO Auto-generated method stub
//		return (UserCommand)getSqlSession().selectList("userInfo",mem_id);
//	}
//
	public void modifyUser(UserCommand User) {
		// TODO Auto-generated method stub
		getSqlSession().update("UserMapper.modifyUser",User);
	}
//
//	public void modifypwd(UserCommand chgpwd) {
//		// TODO Auto-generated method stub
//		getSqlSession().update("modifypwd",chgpwd);
//	}
	

}
