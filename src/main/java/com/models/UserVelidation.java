package com.models;



public class UserVelidation {
	public Boolean isValidate(User user) {
		 if (user.getPassword() != null && user.getPassword().length() >= 10) {
			 return true;
		 }else {
			 return false;
		 }
	}
}
