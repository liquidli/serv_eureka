package com.liquidli.ms.core.login.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liquidli.ms.core.login.util.TokenGenerator;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private TokenGenerator tokenGenerator;

	@PostMapping("/doPwdLogin")
	public ResponseEntity<Map<String, Object>> doPwdLogin(String userName, String pwd) {
		String userId = userName + pwd;
		String token = tokenGenerator.genToken(TokenGenerator.GenMethod.JWT, userId);

		Map<String, Object> attr = new HashMap<>();
		ResponseEntity<Map<String, Object>> responseEntity = new ResponseEntity<>(attr, HttpStatus.OK);
		attr.put("token", token);

		return responseEntity;

	}

}
