package com.board.view;

import java.io.*;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//다운로드 전용클래스(대화상자)
public class DownloadView extends AbstractView {

	public DownloadView() {
		//다운로드 받는 화면으로 전환 contentType="text/html" -> application/download
		setContentType("application/download");//text/html에서 변경
	}
	//사용자로부터 매개변수를 전달받아서 처리해주는 역할(메서드)
	//***1. 다운로드 받을 뷰객체 id 2. 모델 객체명(키명) 3. 전달할 값(다운로드 받을 파일명)
	//return new ModelAndView("downloadView", "downloadFile", downloadFile);
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//1. 다운로드 받을 파일의 정보 얻어오기
		File file=(File)model.get("downloadFile");
		System.out.println("file -> "+file);
		//2. 다운받을 파일의 타입, 크기를 지정 -> response객체
		response.setContentType(getContentType());
		response.setContentLength((int)file.length());//다운로드 받을 파일의 길이 설정
		//브라우저별로 한글처리 -> User-Agent(브라우저의 정보가 저장된 Head값)
		String userAgent=request.getHeader("user-Agent");
		System.out.println("userAgent -> "+userAgent);//MSIE
		boolean ie=userAgent.indexOf("MSIE") > -1;//못찾으면 -1 리턴
		String fileName=null;
		if(ie) {
			//URLEncoder(1. 파일명 2. 캐릭터셋 설정)
			fileName=URLEncoder.encode(file.getName(), "utf-8");
		}else {//영문 -> iso-8859-1
			fileName=new String(file.getName().getBytes("utf-8"), "iso-8859-1");
		}
		//대화상자에서 다운로드 할 수 있도록 옵션을 설정
		//"Content-Disposition"(다운로드 받는 위치) "attachment;filename=\"다운로드 받을 파일명\"
		//exe, bat -> 이진파일도 다운 -> Content-Transfer-Encoding을 binary로 지정
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		//입출력과 연관(입출력객체를 만들어서 전송)
		OutputStream out=response.getOutputStream();//new OutputStream() X (서버 출력객체)
		FileInputStream fis=null;//pc
		try {
			fis=new FileInputStream(file);//경로포함해서 파일명(=업로드 위치)
			//서버로부터 파이을 읽어들여서 다운로드 받음 -> 복사
			FileCopyUtils.copy(fis, out);//1. 다운로드 받는쪽 입력객체명 2. 서버의 출력객체명
		}catch(IOException e) {
			e.printStackTrace();//파일이 삭제된 경우
		}finally {//예외처리와 상관없이 메모리 해제
			if(fis!=null)
				try {fis.close();}catch(IOException e) {}
		}//finally
		out.flush();//입출력 -> 양이 될때까지 그대로 버퍼에 보관X -> flush() -> 바로 출력
	}
}