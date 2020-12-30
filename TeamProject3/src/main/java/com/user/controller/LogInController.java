package com.user.controller;

import javax.servlet.http.HttpServletRequest;
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
public class LogInController {

	@RequestMapping("/SignIn.do")
	public String logInForm() {
		System.out.println("로그인 페이지로 이동완료");
		return "LogIn";
	}
	
	@Autowired
	private UserDao userDao;

	@RequestMapping(value="/LogIn.do", method=RequestMethod.POST)
	public String logIn(UserCommand userCommand, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		UserCommand logIn=userDao.logIn(userCommand);
		System.out.println("로그인");
		if(logIn == null) {
			session.setAttribute("member", null);
		}else {
			session.setAttribute("member", logIn);
		}
		System.out.println("로그인 성공");
		return"/CompleteLogIn";
	}
	
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logout(HttpSession session) {
//		
//		session.invalidate();
//		System.out.println("로그아웃 성공");
//		return "/home";
//	}
	
}
