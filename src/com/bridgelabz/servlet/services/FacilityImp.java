package com.bridgelabz.servlet.services;

import com.bridgelabz.servlet.dao.*;
import com.bridgelabz.servlet.dto.UserDTO;
import com.bridgelabz.servlet.model.User;
import com.bridgelabz.servlet.utility.Utility;

public class FacilityImp implements Ifacility {

	IDBConnection obj = new DBConnectionImp();
	
	@Override
	public void dtomodelMapping(UserDTO userDTO) {
		
		Utility util = new Utility();
		User user = new User();
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setUserName(userDTO.getUserName());
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getPhone());
		user.setPassword(userDTO.getPassword());
		user.setRegDate(util.date());

		obj.register(user);
	}

}
