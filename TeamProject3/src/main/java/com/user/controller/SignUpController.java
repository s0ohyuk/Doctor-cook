package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.user.dao.UserDao;
import com.user.domain.UserCommand;

@Component
@Controller
public class SignUpController {

	@RequestMapping("/agreeSignUp.do")
	public String agreeSignUpForm() {
		return "agreeSignUp";
	}
	
	@RequestMapping("/SignUp.do")
	public String signUpForm() {
		return "SignUp";
	}
	
	@Autowired
	private UserDao userDao;
	
	// 아이디 중복 검사
//	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
//	@ResponseBody
//	public String memberIdChkPOST(String mem_id) {
//	System.out.println("id중복 체크 실행");	
//	int result = userDao.idCheck(mem_id);
//		if(result != 0) {
//			return "fail";	// 중복 아이디가 존재
//		} else {
//			return "success";	// 중복 아이디 x
//		}	
//	}
		
	@RequestMapping(value="/join.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("CompleteSignUp") UserCommand userCommand) {	
	userDao.signUp(userCommand);
	System.out.println("submit호출");
	return "CompleteSignUp";
	}
}
