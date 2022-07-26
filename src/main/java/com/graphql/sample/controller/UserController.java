package com.graphql.sample.controller;

import com.graphql.sample.dto.UserDto;
import com.graphql.sample.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class UserController {

	private UserService userService;


	public UserController(UserService userService) {
		this.userService = userService;
	}

	@QueryMapping(name = "userById")
	public UserDto findUserById(@Argument Long id) {
		return userService.findById(id);
	}

	@MutationMapping(name = "removeById")
	public String removeUserById(@Argument Long id) {
		return userService.removeById(id);
	}

	@MutationMapping(name = "save")
	public UserDto save(@Argument(name = "userInput") UserDto user) {
		return  userService.save(user);
	}

	@QueryMapping(name = "users")
	public List<UserDto> findAll() {
		return userService.findAll();
	}

}
