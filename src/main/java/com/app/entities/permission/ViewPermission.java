package com.app.entities.permission;

import com.app.entities.User;

public interface ViewPermission {

	boolean hasPermission(User u);
}
