package com.board.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.board.domain.BoardCommand;

//��ȿ�� �˻縦 �ϴ� ���=>Validator�������̽��� ��ӹ޾ƶ�

public class BoardValidator implements Validator{

	//1.��ȿ�� �˻縦 �� Ŭ�������� �������ִ� �޼���
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		//����) return DTOŬ������.class.isAssignableFrom(clazz);
		return BoardCommand.class.isAssignableFrom(clazz);
	}
	/*
	    WriteController���� ȣ��
	    ��ȿ�� �˻�(1.�Է¹��� �����(DTO��ü(=Ŀ�ǵ尴ü) 2.���������� ���� ��ü��
	      1.required.pwd=��ȣ�� �ʼ��Է��Դϴ�
	      1.required.command.pwd->2.required.pwd->3.required.java.lang.String
	      4.required������ ã�´�.
	*/
	//2.��ȿ���˻縦 ���ִ� �޼���->�����޼����� �ۼ�->����->���� ���
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		//�Է����� �ʾҰų� ������ üũ���ִ� �޼���->���������� ����(������ü)
		//1.������ü�� 2.�����ų �ʵ�� 3.�����ų �����ڵ��
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writer", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "required");
		//
	}
}




