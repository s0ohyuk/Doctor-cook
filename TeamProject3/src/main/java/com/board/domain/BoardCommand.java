package com.board.domain;

import java.sql.Date;

//commons-fileupload~.jar����
import org.springframework.web.multipart.MultipartFile;

//���̺��� �ʵ�� ������ �ִ� Ŭ����(DTO)

public class BoardCommand {

	private int seq;
	private String writer,title,content,pwd;//�ۼ���,����,����,��ȣ
	private int hit;//��ȸ��
	private Date regdate;//�ۼ���¥
	//�߰�(���Ͼ��ε�=>�ڷ��)
	private MultipartFile upload;//���ε��Ҷ� �ʿ���ϴ� ��ü
	private String filename;//���ε��� ���ϸ�
	//--------------------------------------------------------------
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	//��������� �� ���
	public String toString() {
		// TODO Auto-generated method stub
		return "BoardCommand[seq="+seq+",writer="+writer+",title="
				   +title+",content="+content+",pwd="+pwd+",hit="
				   +hit+",regdate="+regdate+",upload="+upload
				   +",filename="+filename+"]";
	}
	//
}
