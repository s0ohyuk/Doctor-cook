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

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;
import com.board.util.FileUtil;
import com.board.validator.BoardValidator;

//게시물에 글쓰기 or 회원가입
@Component
@Controller
public class WriterController {
        //Logger��ü=>����� �Է��ߴ��� üũ�ؼ� �� ����� �ֿܼ� ���
	   //                      �����ִ� ��ü
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private BoardDao boardDao;
	
	/*
	 * �ϳ��� ��û��ɾ�=>�ϳ��� ��Ʈ�ѷ��� ���X
	 * �ϳ��� ��Ʈ�ѷ�->�������� ��û��ɾ ����ؼ� ����� ����.
	 * ���� ��û��ɾ GET or POST���� ���������� �����ϴ� �Ӽ�
	 * method=RequestMethod.GET | method=RequestMethod.POST
	 */
	 //1.�۾��� ������ �̵�(Get���)
	@RequestMapping(value="/board/write.do",method=RequestMethod.GET)
	public String form() {  //�޼������ ���Ƿ� �ۼ�
		System.out.println("�ٽ� ó������ ���� �Է¹ޱ����ؼ� form()ȣ���!");
		return "boardWrite";// return "�̵��� ��������'//definition name�� ����
	}
	
	//2.�����޼��� ���=>�ٽ� �ʱ�ȭ�� �����ϰ� ����->@ModelAttribute("Ŀ�ǵ尴ü ��Ī��")
	@ModelAttribute("command")
	public BoardCommand forBacking() { //��ȯ�� (DTO��) ������ �޼����
		System.out.println("forBacking()ȣ���!");
		return new BoardCommand();//BoardCommand bc=new BoardCommand();
	}
	//3.�Է��ؼ� ��ȿ���˻�->�����߻�
	//BindingResult->��ȿ���˻綧���� �ʿ�=>����������ü�� ����
	@RequestMapping(value="/board/write.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") BoardCommand command,
			                       BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("BoardCommand=>"+command);//�Է¹��� ���� ���
			//�αװ�ü��.debug(��´���ڸ� �Է�)
		}
		//��ȿ���˻�
		new BoardValidator().validate(command, result);
		//���������� ����ִٸ�
		if(result.hasErrors()) {
			return form(); //"boardWrite"->boardWrite.jsp�� �̵��϶�
		}
		//�۾��� �� ���ε�=>�����=>����ó��
		try {
			String newName="";//���ε��� ������ ����� ���ϸ��� ����
			//���ε�Ǿ��ִٸ�
			if(!command.getUpload().isEmpty()) {
				//Ž���⿡�� ������ �����̸�->getOriginalFileName() aaaa.txt->1234222.txt
				newName=FileUtil.rename(command.getUpload().getOriginalFilename());
				System.out.println("newName=>"+newName);
				//DTO���� �ٲ��̸�����->���̺��� �ٲ��̸� ����
				command.setFilename(newName);//->springbord2->filename�ʵ�
			}
			//�ִ밪+1
			int newSeq=boardDao.getNewSeq()+1;
			System.out.println("newSeq=>"+newSeq);//1->2
			//�Խù���ȣ->���->����
			command.setSeq(newSeq);//2
			//�۾��� ȣ��
			boardDao.insert(command);//DB�� �ݿ�
			//������ upload������ ���ε��� ������ ����(����)
			if(!command.getUpload().isEmpty()) {
				File file=new File(FileUtil.UPLOAD_PATH+"/"+newName);
				//���������� ����������(���� ����)
				command.getUpload().transferTo(file);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		
		//return "redirect:��û��ɾ�"; =>return "�̵��� ��������"
		return "redirect:/board/list.do";
	}
}





