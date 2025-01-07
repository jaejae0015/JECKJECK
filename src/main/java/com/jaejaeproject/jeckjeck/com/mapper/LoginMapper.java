package com.jaejaeproject.jeckjeck.com.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.jaejaeproject.jeckjeck.com.dto.LoginDTO;

@Mapper
public interface LoginMapper {
	public LoginDTO selectUserLoginInfo(LoginDTO loginUser);
}
