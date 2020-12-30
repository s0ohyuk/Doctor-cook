package com.user.domain;

import java.sql.Date;

public class UserCommand {

	 private String mem_id; 
	 private String mem_pass;
	 private String mem_name;
	 private String mem_email;
	 private int mem_born;
	 private int mem_zipcode;
	 private String mem_addr1;
	 private String mem_addr2;
	 private int mem_phone;
	 private Date mem_join;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
		System.out.println("확인용idset");
	}
	public String getMem_pass() {
		System.out.println("확인용idget");
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
		System.out.println("확인용passset");
	}
	public String getMem_name() {
		System.out.println("확인용passget");
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
		System.out.println("확인용nameset");
	}
	public String getMem_email() {
		System.out.println("확인용nameget");
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
		System.out.println("확인용emailset");
	}
	public int getMem_born() {
		System.out.println("확인용emailget");

		return mem_born;
	}
	public void setMem_born(int mem_born) {
		this.mem_born = mem_born;
		System.out.println("확인용bornset");
	}
	public int getMem_zipcode() {
		System.out.println("확인용zipget");
		return mem_zipcode;
	}
	public void setMem_zipcode(int mem_zipcode) {
		this.mem_zipcode = mem_zipcode;
		System.out.println("확인용zipset");
	}
	public String getMem_addr1() {
		System.out.println("확인용add1get");
		return mem_addr1;
	}
	public void setMem_addr1(String mem_addr1) {
		this.mem_addr1 = mem_addr1;
		System.out.println("확인용add1set");
	}
	public String getMem_addr2() {
		System.out.println("확인용add2get");
		return mem_addr2;
	}
	public void setMem_addr2(String mem_addr2) {
		this.mem_addr2 = mem_addr2;
		System.out.println("확인용add2set");
	}
	public int getMem_phone() {
		System.out.println("확인용phoneget");
		return mem_phone;
	}
	public void setMem_phone(int mem_phone) {
		this.mem_phone = mem_phone;
		System.out.println("확인용phoneset");
	}
	public Date getMem_join() {
		System.out.println("확인용joinget");
		return mem_join;
	}
	public void setMem_join(Date mem_join) {
		System.out.println("확인용joinset");
		this.mem_join = mem_join;
	}
	@Override
	public String toString() {
		return "UserCommand [mem_id=" + mem_id + ", mem_pass=" + mem_pass + ", mem_name=" + mem_name + ", mem_email="
				+ mem_email + ", mem_born=" + mem_born + ", mem_zipcode=" + mem_zipcode + ", mem_addr1=" + mem_addr1
				+ ", mem_addr2=" + mem_addr2 + ", mem_phone=" + mem_phone + ", mem_join=" + mem_join + "]";
	} 
}
