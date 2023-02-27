package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.dto.UserDto;
import com.axis.service.UserService;

@RestController
@RequestMapping("/api/banking/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto)
	{
		return new ResponseEntity<UserDto>(userService.addUser(userDto), HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAllUser()
	{
		return new ResponseEntity<List<UserDto>>(userService.getAllUser(), HttpStatus.OK);
	}
	
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable  int id)
	{
		return new ResponseEntity<UserDto>(userService.getUserById(id), HttpStatus.OK);
	}
	
}
