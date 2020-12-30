package com.user.service;

import com.user.domain.UserCommand;

public interface UserService {

	public void signUp(UserCommand userCommand);
	
	public UserCommand logIn(UserCommand userCommand);
	
}
