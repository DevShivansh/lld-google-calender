package com.app.entities.permission;

import com.app.entities.User;

public class ViewAnyone implements ViewPermission {

	@Override
	public boolean hasPermission(User u) {
		return true;
	}

}
