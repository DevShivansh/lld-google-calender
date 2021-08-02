package com.app.entities.permission;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.app.entities.User;

public class ViewRestrictedMembers implements ViewPermission{

	private Set<Long> accessGrantedUsers;
	
	

	public ViewRestrictedMembers(List<User> accessGrantedUsers) {
		super();
		this.accessGrantedUsers = accessGrantedUsers.stream().map(u -> u.getUserID()).collect(Collectors.toSet());
	}


	public void addAccessToUser(User u) {
		accessGrantedUsers.add(u.getUserID());
	}
	

	@Override
	public boolean hasPermission(User u) {
		// TODO Auto-generated method stub
		return accessGrantedUsers.contains(u.getUserID());
	} 
}
