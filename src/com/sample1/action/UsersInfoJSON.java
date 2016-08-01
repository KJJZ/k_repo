package com.sample1.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sample1.service.UsersInfoService;

import hibernate.domain.UsersInfo;

@SuppressWarnings("serial")
public class UsersInfoJSON extends ActionSupport {
	private UsersInfoService usersInfoService;
	private Map<String, List<String>> usersinfo = new HashMap<String, List<String>>();
	
	public void setUsersInfoService(UsersInfoService usersInfoService) {
		this.usersInfoService = usersInfoService;
	}
	
	@JSON(name="users")
	public Map<String, List<String>> getUsersinfo() {
		if(usersinfo.isEmpty()){
			List<UsersInfo> l = usersInfoService.listAll();
			Iterator<UsersInfo> itr = l.iterator();
			usersinfo.clear();
			while(itr.hasNext()){
				UsersInfo ui = itr.next();
				List<String> info = new ArrayList<String>();
				info.add(ui.getName());
				info.add(ui.getAge().toString());
				usersinfo.put(ui.getId().toString(), info);
			}
		}
		return usersinfo;
	}
	
	public void setUsersinfo(Map<String, List<String>> usersinfo) {
		this.usersinfo = usersinfo;
	}
}
