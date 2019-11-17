package org.streamlined.lms.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.streamlined.lms.user.model.CommonRequest;
import org.streamlined.lms.user.service.UserServiceIntr;

@CrossOrigin(origins = "*")
@RestController
public class LmsUserApiController {
	
	@Autowired
	UserServiceIntr userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<String> getAllUsers() {
		
		return userService.getAllUsers(new CommonRequest());
		
	}

}
