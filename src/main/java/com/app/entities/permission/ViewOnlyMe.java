package com.app.entities.permission;

import com.app.entities.User;

public class ViewOnlyMe implements ViewPermission {

	private User accountOwner;
	
	@Override
	public boolean hasPermission(User u) {
		// TODO Auto-generated method stub
		return accountOwner.getUserID() == u.getUserID();
	}

}
