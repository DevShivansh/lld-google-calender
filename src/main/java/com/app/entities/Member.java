package com.app.entities;

import com.app.entities.permission.ViewPermission;
import com.app.enums.UserType;

public class Member extends User{

	private static final UserType userType = UserType.MEMBER;
	
	
	public Member(String userName, String emailID, ViewPermission viewPermission) {
		super(userName, emailID, viewPermission);
	}

	@Override
	public UserType getUserType() {
		// TODO Auto-generated method stub
		return userType;
	}

	
}
