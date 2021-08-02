package com.app.entities;

import com.app.enums.UserType;
import com.app.enums.ViewPermission;

public class Member extends User{

	private static final UserType userType = UserType.MEMBER;
	
	private ViewPermission viewPermission;
	
	public Member(String userName, String emailID, ViewPermission viewPermission) {
		super(userName, emailID);
		this.viewPermission = viewPermission;
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserType getUserType() {
		// TODO Auto-generated method stub
		return userType;
	}

	@Override
	public ViewPermission getViewPermission() {
		// TODO Auto-generated method stub
		return viewPermission;
	}

}
