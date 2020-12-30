package com.board.controller;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;
import com.board.util.FileUtil;
import com.board.validator.BoardValidator;

@Component
@Controller
public class UpdateController {
	//Logger 객체 -> 제대로 입력했는지 체크해서 그 결과를 콘솔에 출력시켜주는 객체
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private BoardDao boardDao; //@Autowired -> @Inject
	
	//1. 글 수정 폼으로 이동(Get방식) -> boardModify.jsp
	//형식) value="요청명령어", method=RequestMethod.GET (Get방식으로 요청했을때) -> @GetMapping
	@RequestMapping(value="/board/update.do",method=RequestMethod.GET)
	//public String form() {  글쓰기의 경우
	public ModelAndView form(@RequestParam("seq") int seq) {
		System.out.println("다시 처음부터 값을 입력받기위해 form()호출됨");
		BoardCommand boardCommand=boardDao.selectBoard(seq);
		//return "boardModify";
		//1. 이동할 페이지명(확장자 생략) 2. 키명 3. 전달할 값
		return new ModelAndView("boardModify", "command", boardCommand);
	}
	
	//2. 입력해서 유효성검사 -> 에러유발
	//BindingResult -> 유효성검사때문에 필요 -> 에러정보객체를 저장시켜주는 역할
	@RequestMapping(value="/board/update.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") BoardCommand command,
			                       BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("BoardCommand=>"+command);//입력받은 값을 출력
			//유효성검사
		}
		new BoardValidator().validate(command, result);
		//에러정보가 들어있다면 -> 다시 입력을 받을 준비를 해야한다.
		if(result.hasErrors()) {
			return "boardModify";//"boardModify" -> boardModify.jsp로 이동
		}
		//글수정 및 업로드 -> 변경전데이터 -> DB 비밀번호 =웹상의 입력한 비밀번호
		BoardCommand board=null;
		String oldFileName="";//변경전 파일명
		board=boardDao.selectBoard(command.getSeq());
		//DB 비밀번호 =웹상의 입력한 비밀번호
		if(!board.getPwd().contentEquals(command.getPwd())) {
			result.rejectValue("pwd", "invalidPassword");//1. 에러메세지를 적용시킬필드명, 2. 에러코드명
			return "boardModify";//암호가 틀리기때문에 다시 입력받을 수 있는 boardModify.jsp로 이동
		}else {//비밀번호가 일치한다면
			/*
			 * 기본파일명 -> 업로드된 파일이 존재 -> 기존파일 삭제 -> 새로운 파일로 세팅 -> 전송 -> DB저장
			 */
			oldFileName=board.getFilename();//DB상의 원래 기존파일명
			
			//1. 업로드 되어있다면 업로드 처리
			if(!command.getUpload().isEmpty()) {
				//탐색기 -> 선택한 파일이름 -> getOriginalFileName()
				try {
					command.setFilename(FileUtil.rename(command.getUpload().getOriginalFilename()));
				}catch(Exception e) {e.printStackTrace();}
			}else {//새로운 파일로 업로드하지 않은 경우(기존 파일은 덮어쓰기)
				command.setFilename(oldFileName);
			}
			//글수정 메서드 호출
			boardDao.update(command);//DB에 저장 -> aaa.txt -> c.jpg
			//업로한 파일이 이다면 올려준파일을 내 서버의 upload로 이동하라
			if(!command.getUpload().isEmpty()) {
				try {
					//새로 변경된 파일명을 업로드 위치로 전송하기위한 파일객체 정보를 얻어옴
					File file=new File(FileUtil.UPLOAD_PATH+"/"+command.getFilename());
					//물리적으로 데이터 전송(파일 전송)
					command.getUpload().transferTo(file);//실시간으로 이동
				}catch(IOException e) {
					e.printStackTrace();
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				//aaa.txt -> c.jpg로 변경 -> 기존 파일은 삭제하는 구문이 필요
				if(oldFileName!=null) {
					FileUtil.removeFile(oldFileName);
				}
			}//if(!command.getUpload().isEmpty()) {
			
			//return "redirect:/요청명령어"
		}//else -> 암호가 맞다면
		return "redirect:/board/list.do";//ListController -> /boardList.jsp로 이동
	}
}





