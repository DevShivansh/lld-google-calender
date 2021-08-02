package com.app.entities.permission;

import com.app.entities.User;

public class ViewMembers implements ViewPermission{

	@Override
	public boolean hasPermission(User u) {
		// TODO Auto-generated method stub
		return u.isOrganizationMemeber();
	}

}
