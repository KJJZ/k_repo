package com.sample1.interceptor;

import java.util.Date;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("serial")
public class MyMethodInterceptor1 extends MethodFilterInterceptor {
	private String name;

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(getName()+" "+"enter method interceptor "+(new Date()).toString());
		String result = actionInvocation.invoke();
		System.out.println(getName()+" "+"quit method interceptor "+(new Date()).toString());
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
