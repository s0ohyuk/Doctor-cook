package com.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.home.dao.HomeDao;
import com.home.domain.ClassCommand;
import com.home.domain.TeacherCommand;

@Component
@Controller 
public class HomeController {

	@Autowired
	private HomeDao homeDao;
	
	@RequestMapping("/home.do")
	public ModelAndView process() {
		List<ClassCommand> cl=null;
		List<TeacherCommand> tl=null;
		cl=homeDao.classList();
		tl=homeDao.teacherList();
		
		ModelAndView mav=new ModelAndView("home");
		mav.addObject("cl", cl);
		mav.addObject("tl", tl);
		return mav;
	}
}








