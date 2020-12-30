package com.board.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;
import com.board.util.FileUtil;
import com.board.validator.BoardDeleteValidator;

//게시물에 글쓰기 or 회원가입
@Component
@Controller
public class DeleteController {
	//Logger 객체 -> 제대로 입력했는지 체크해서 그 결과를 콘솔에 출력시켜주는 객체
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private BoardDao boardDao; //@Autowired -> @Inject
	
	//1. 글 삭제 폼으로 이동(Get방식) -> boardDelete.jsp
	//형식) value="요청명령어", method=RequestMethod.GET (Get방식으로 요청했을때) -> @GetMapping
	@RequestMapping(value="/board/delete.do",method=RequestMethod.GET)
	public String form() {
		return "boardDelete";
	}
	
	//에러메세지 출력 -> 다시 초기화 -> 입력받은 데이터 재입력 -> reset
	@ModelAttribute("command")
	public BoardCommand forBacking() {
		System.out.println("다시 암호를 재입력하기위해서 초기화!");
		return new BoardCommand();
	}
	
	//2. 입력해서 유효성검사 -> 에러유발
	//BindingResult -> 유효성검사때문에 필요 -> 에러정보객체를 저장시켜주는 역할
	@RequestMapping(value="/board/delete.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") BoardCommand command,
			                       BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("BoardCommand=>"+command);//입력받은 값을 출력
			//유효성검사
		}
		new BoardDeleteValidator().validate(command, result);
		//에러정보가 들어있다면 -> 다시 입력을 받을 준비를 해야한다.
		if(result.hasErrors()) {
			return form();
		}
		//글수정 및 업로드 -> 변경전데이터 -> DB 비밀번호 =웹상의 입력한 비밀번호
		BoardCommand board=null;

		board=boardDao.selectBoard(command.getSeq());
		//DB 비밀번호 =웹상의 입력한 비밀번호
		if(!board.getPwd().contentEquals(command.getPwd())) {
			result.rejectValue("pwd", "invalidPassword");//1. 에러메세지를 적용시킬필드명, 2. 에러코드명
			return form();//암호가 틀리기때문에 다시 입력받을 수 있는 boardDelete.jsp로 이동
		}else {//비밀번호가 일치한다면
			//글삭제 메서드 호출
			boardDao.delete(command.getSeq());//DB에 저장 -> aaa.txt -> c.jpg
			//업로드가 된 파일을 삭제하는 경우
			if(board.getFilename()!=null) {
				FileUtil.removeFile(board.getFilename());//DB상에 저장된 파일의 정보
			}
		}//else -> 암호가 맞다면
		return "redirect:/board/list.do";//ListController -> /boardList.jsp로 이동
	}
}





