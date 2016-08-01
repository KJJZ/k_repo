package com.sample1.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sample1.pojo.User;

@SuppressWarnings("serial")
public class loginAction extends ActionSupport {
	private String name;
	private String pass;
	private User user;
	
	public loginAction(){
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String execute() {
		return SUCCESS;
	}
	
	public String method1(){
		System.out.println("this is method1");
		return SUCCESS;
	}

	public String method2(){
		System.out.println("this is method2");
		return SUCCESS;
	}
	public String method3(){
		System.out.println("this is method3");
		return SUCCESS;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	/*
	public void validate(){
		System.out.println("here is validate()");
		if(name == null || name.length()==0){
			addFieldError("name",getText("username.required"));
		}
		System.out.println("quit validate()");
	}
	*/
}
