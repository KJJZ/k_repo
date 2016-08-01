package com.sample1.action;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.PreResultListener;
import com.sample1.pojo.User;
import com.sample1.service.UsersInfoService;

import hibernate.domain.UsersInfo;


@SuppressWarnings("serial")
public class UsersInfoAction extends ActionSupport {
	private UsersInfoService usersInfoService;
	private Map<String, String> usersinfo = new HashMap<String, String>();
	private Integer counter;
	private List<User> user;
	
	public String execute(){
		if(counter==null){
			counter = 1;
		}else{
			counter ++;
		}
		ActionInvocation invocation = ActionContext.getContext().getActionInvocation();
		invocation.addPreResultListener(new PreResultListener(){
			public void beforeResult(ActionInvocation invocation, String resultCode){
				System.out.println("return code: "+resultCode);
			}
		});
		List<UsersInfo> l = getUsersInfoService().listAll();
		Iterator<UsersInfo> itr = l.iterator();
		usersinfo.clear();
		while(itr.hasNext()){
			UsersInfo ui = itr.next();
			usersinfo.put(ui.getId().toString(),ui.getName());
		}
		//throw new java.sql.SQLException("this is a sql exception thown by execute");
		return SUCCESS;
	}

	public UsersInfoService getUsersInfoService() {
		return usersInfoService;
	}

	public void setUsersInfoService(UsersInfoService usersInfoService) {
		this.usersInfoService = usersInfoService;
	}
	
	@JSON(name="users")
	public Map<String, String> getUsersinfo() {
		return usersinfo;
	}
	
	public Integer getCounter() {
		return counter;
	}
	public void setCounter(Integer counter) {
		this.counter = counter;
	}
	
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}

}
