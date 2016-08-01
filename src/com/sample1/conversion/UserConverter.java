package com.sample1.conversion;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.util.StrutsTypeConverter;

import com.sample1.pojo.User;

public class UserConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		if(arg2 == Set.class){
			Set result = new HashSet();
			for(int i=0; i<arg1.length; i++){
				String[] userValues = arg1[i].split(",");
				User user = new User();
				user.setName(userValues[0]);
				user.setPass(userValues[1]);
				result.add(user);
			}
			return result;
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(arg1.getClass()==Set.class){
			Set users = (Set) arg1;
			String result="[";
			for(Object obj : users){
				User user = (User) obj;
				result += "<"+user.getName()+","+user.getPass()+">";
			}
			result += "]";
			return result;
		}
		return null;
	}

}
