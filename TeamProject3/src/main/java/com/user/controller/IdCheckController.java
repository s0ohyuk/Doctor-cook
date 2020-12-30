package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.user.dao.UserDao;

@Component
@Controller
public class IdCheckController {

	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/idcheck", method = RequestMethod.GET)
	@ResponseBody
	public boolean checkmemid(@RequestParam("mem_Id") String mem_id) {
		
		String user = userDao.checkmemid(mem_id);
		
		if(user == null) {
			return true;
		}else {
			return false;
		}
	}

}
