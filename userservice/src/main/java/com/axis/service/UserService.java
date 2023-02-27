package com.axis.service;

import java.util.List;

import com.axis.dto.UserDto;

public interface UserService {

	public UserDto addUser(UserDto userDto);
	
	public List<UserDto> getAllUser();
	
	public UserDto getUserById(int id);
	
	public UserDto updateUserByUserID(long id, UserDto userDto);

	public void deleteUserByUserId(long id);
}
