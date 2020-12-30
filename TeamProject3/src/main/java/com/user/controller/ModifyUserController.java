package com.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user.dao.UserDao;
import com.user.domain.UserCommand;

@Component
@Controller
public class ModifyUserController {

	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/ModifyUser.do", method=RequestMethod.GET)
	public String modifyUserForm() {
		System.out.println("회원정보 수정페이지로 이동 완료");
		return "Modify";
	}
	
	@RequestMapping(value="/UpdateUser.do", method=RequestMethod.POST)
	public String updateUser(UserCommand userCommand,HttpSession session) {
		userDao.modifyUser(userCommand);
		System.out.println("수정한 회원정보 DB저장 완료");
		session.invalidate();
		System.out.println("session값 변경 완료");
		return"CompleteModify";
	}
}
