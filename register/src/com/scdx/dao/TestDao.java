package com.scdx.dao;

import java.util.ArrayList;

import com.scdx.bean.User;

public class TestDao {
    static User user=new User();
	public static <T> void main(String[] args) {
		UserDao ud=new UserDao();
		ArrayList<T> list=new ArrayList<>();
		list=ud.getUserList();
		System.out.println("start to iterate:"+list.size());
		
		for(int i=0;i<list.size();i++){
			user=(User) list.get(i);
			System.out.print(list.get(i)+">");
			System.out.print("用户名:"+user.getUsername()+"/");
			System.out.println("密码:"+user.getPassword());
			
		}

	}

}
