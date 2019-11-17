package org.streamlined.lms.user.serviceImpl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.streamlined.lms.user.model.CommonRequest;
import org.streamlined.lms.user.service.UserServiceIntr;

@Service
public class UserServiceImpl implements UserServiceIntr {

	String BASE_URL = "https://captivateprimeeu.adobe.com/primeapi/v1/";

	public ResponseEntity<String> getAllUsers(CommonRequest commonRequest) {

		RestTemplate restCall = null;
		HttpHeaders headers = null;
		HttpEntity<String> requestEntity = null;
		ResponseEntity<String> response = null;
		String responseBody = null;
		UriComponentsBuilder builder = null;
		try {
			String breezSession = "97af0363e61bebe28a69a4693f4f49e5";
			// System.out.println("get Token "+getToken());
			restCall = new RestTemplate();
			headers = new HttpHeaders();
			headers.set("Authorization", "oauth " + breezSession);
			headers.add("Accept", "application/vnd.api+json;charset=UTF-8");
			headers.add("Content-Type", "application/json");
			requestEntity = new HttpEntity<>(headers);
			builder = UriComponentsBuilder.fromHttpUrl(BASE_URL).path("/users/");
			response = restCall.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, String.class);
			if (response.getStatusCode() == HttpStatus.OK) {
				return response;
			}
			System.out.println("Response Received and it is [" + responseBody + "]");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			restCall = null;
			headers = null;
			requestEntity = null;
			response = null;
		}
		return response;
	}

}
