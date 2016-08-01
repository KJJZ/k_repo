package com.sample1.interceptor;

import java.util.Date;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class myInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("enter myInterceptor: "+(new Date()).toString());
		String result = actionInvocation.invoke();
		System.out.println("quit myInterceptor: "+(new Date()).toString());
		return result;
	}

}
