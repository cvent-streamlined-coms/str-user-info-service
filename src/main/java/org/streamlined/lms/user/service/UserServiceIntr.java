package org.streamlined.lms.user.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.streamlined.lms.user.model.CommonRequest;

@Service
public interface UserServiceIntr {

	public ResponseEntity<String> getAllUsers(CommonRequest commonRequest);

}
