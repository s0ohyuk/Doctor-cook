package com.board.util;

import java.io.File;

//���Ͼ��ε�� ���ε��� ������� �� ������ ���̸��� �ο�(������)
public class FileUtil {
	
	//���ε�� �ٿ�ε� ���
	public static final String UPLOAD_PATH="C:/webtest/4.jsp/sou/SpringFileBoard2/src/main/webapp/upload";
	
	//1.Ž������ �������ϸ� �޾Ƽ� ó���޼���(ex test.txt)
	public static String rename(String filename) throws Exception {
		if(filename==null) return null;//���ε� X ->�̸� ����X
		//���̸� ��Ģ=>�ý��۳�¥+��������(0~49)->����
		String newName=Long.toString(System.currentTimeMillis())+(int)(Math.random()*50);
		System.out.println("newName(����)=>"+newName);
		return rename(filename,newName);
	}

	//2.������ ���ο� ���ϸ��� �����ϴ� ����->Ȯ���� ����=>����� �̸��� ���ؼ�
	//ex) testkimaaaa.txt(�ڿ��� �˻�)->123aad.TXT
	public static String rename(String filename,String newName) throws Exception {
		if(filename==null) return null;
		//Ȯ���� ���ϱ�
		int idx=filename.lastIndexOf(".");//��ã���� -1�� ����
		String extention="";//Ȯ���� ����
		String newFileName="";//�����ϸ��� ����
		if(idx!=-1) {
			extention=filename.substring(idx);
			System.out.println("extention=>"+extention);
		}
		//�����ϸ�
		int newIdx=newName.lastIndexOf(".");//Ȯ���ڸ� ������ ����� ���ϸ�
		if(newIdx!=-1) {
			newName=newName.substring(0,newIdx);//0�� ���� ->newIdx-1
			System.out.println("newName(����� ���ϸ�)=>"+newName);
		}
		newFileName=newName+extention.toLowerCase();//Ȯ����(��)->�ҹ���
		return newFileName;//�������� ���ε�� ���ϸ�
	}
	//�ۼ���->���ε�� ���ϵ� ����->���� ���ε�� ���� ����->���� ���ε��
	//���ϻ���->��������
	public static void removeFile(String filename) {
		File file=new File(UPLOAD_PATH,filename);//1.���,2.���ϸ�
		if(file.exists()) file.delete();//�� ��ο� ������ �����Ѵٸ� �����϶�
	}
}





