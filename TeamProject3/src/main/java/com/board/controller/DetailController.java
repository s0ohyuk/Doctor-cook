package com.board.controller;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;
import com.board.util.FileUtil;
import com.board.util.StringUtil;

@Component
@Controller
public class DetailController {

	private Logger log=Logger.getLogger(this.getClass());//자동으로 로그처리할 클래스명
	
	@Autowired
	private BoardDao boardDao; //byType
	
	//  /board/detail.do?seq=4
	@RequestMapping("/board/detail.do")
	public ModelAndView process(@RequestParam("seq") int seq) {
		//int seq=Integer.parseInt(request.getParameter("seq"));
		if(log.isDebugEnabled()) {//로그객체가 작동중이라면(디버깅상태)
			log.debug("seq -> "+seq);//System.out.println("seq -> "+seq); ? 처리X
		}
		//1. 조회수 증가
		boardDao.updateHit(seq);
		BoardCommand board=boardDao.selectBoard(seq);
		//글내용 -> aaaa\r\n -> <br>
		board.setContent(StringUtil.parseBr(board.getContent()));//\r\n을 ""으로 변환
		/*
		ModelAndView mav=new ModelAndView("boardView");
		mav.addObject("board", board);
		return mav;
		*/
		//1. 이동할 페이지명 2. 전달할 키명 3. 전달할 값
		return new ModelAndView("boardView", "board", board);
	}
	
	//다운로드 처리해주는 메서드 작성
	@RequestMapping("/board/file.do")
	public ModelAndView download(@RequestParam("filename") String filename) {
		//1. 다운로드 받을 파일의 위치와 이름을 알아야 된다.
		File downloadFile=new File(FileUtil.UPLOAD_PATH+"/"+filename);
		//2. 스프링에서 다운로드 받는 뷰를 따로 작성 -> AbstractView를 상속받아서 작성
		//1. 다운로드 받을 뷰객체 id 2. 모델 객체명(키명) 3. 전달할 값(다운로드 받을 파일명)
		return new ModelAndView("downloadView", "downloadFile", downloadFile);
	}
}