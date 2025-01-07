package com.jaejaeproject.jeckjeck.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaejaeproject.jeckjeck.com.dto.LoginDTO;
import com.jaejaeproject.jeckjeck.com.mapper.LoginMapper;
import com.jaejaeproject.jeckjeck.com.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired 
	private LoginMapper loginMapper;
	
	@Override
	public LoginDTO getLoginUserInfo(LoginDTO loginUser) {
		System.out.println("##################"+loginUser.userid);
		LoginDTO loginInfo = loginMapper.selectUserLoginInfo(loginUser);
		
		System.out.println("@@@@@@@@@@@@@@@@@"+loginInfo.userid);
		return loginInfo;
	}

}
