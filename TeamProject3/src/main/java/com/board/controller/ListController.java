package com.board.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//�߰� �޼��� ȣ�� �� ����¡ ó���κ�
import com.board.dao.BoardDao;//DB
import com.board.domain.BoardCommand;
import com.board.util.PagingUtil;

@Component
@Controller 
public class ListController {

	//private Logger log=Logger.getLogger(ListController.class); //�α׸� ó���� Ŭ������
	private Logger log=Logger.getLogger(this.getClass());//this.getClass()->����Ŭ������
	
	@Autowired
	private BoardDao boardDao;//�ڵ����� Setter Method ȣ��X=>��������ü �־���(byType)
	
	@RequestMapping("/board/list.do")
	public ModelAndView process
	   (@RequestParam(value="pageNum",defaultValue="1") int currentPage,
	    @RequestParam(value="keyField",defaultValue="") String keyField,
	    @RequestParam(value="keyWord",defaultValue="") String keyWord) {
		if(log.isDebugEnabled()) { //�αװ�ü�� �������������� �ƴ����� üũ
			System.out.println("����� ���� list.do");
			log.debug("currentPage:"+currentPage); //log.debug�޼��� ���
			log.debug("keyField:"+keyField);
			log.debug("keyWord:"+keyWord);
		}
		//�˻��о�,�˻�� ����->parameteType="map"
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("keyField", keyField);
		map.put("keyWord", keyWord);
		
		//�ѷ��ڵ�� �Ǵ� �˻��� ���� �ѷ��ڵ��
		int count=boardDao.getRowCount(map);
		//����¡ ó��  1.���������� 2.�ѷ��ڵ�� 3.�������� �Խù��� 4.���� �������� 5.��û��ɾ�
		PagingUtil page=new PagingUtil(currentPage,count,3,3,"list.do");
		//start=>�������� �� ù��° ������ �Խù� ��ȣ
		map.put("start",page.getStartCount());//<->map.get("start")=>#{start}
		map.put("end", page.getEndCount());
		
		List<BoardCommand> list=null;
		if(count > 0) {
			System.out.println("����� DAOȣ��");
			list=boardDao.list(map);//keyField,keyWord,start,end
		}else {
			list=Collections.emptyList();//0 ����
		}
		System.out.println("ListControllerŬ������ count=>"+count);
		
		ModelAndView mav=new ModelAndView("boardList");//boardList.jsp���� 
		mav.addObject("count",count);//�ѷ��ڵ��
		mav.addObject("list",list);//���ڵ� ��ü��
		mav.addObject("pagingHtml",page.getPagingHtml());//��ũ���ڿ��� ����
		
		return mav;
	}
}








