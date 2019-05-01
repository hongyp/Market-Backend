package com.itlize.marketBackend.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.itlize.marketBackend.Util.exceptions.ApiErrorResponse;
import com.itlize.marketBackend.Util.exceptions.AuthenticationException;
import com.itlize.marketBackend.Util.exceptions.UserNotFoundException;

@RestControllerAdvice
@CrossOrigin(origins="http://localhost:4200")
public class WebControllerAdvice {
	
//	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handler(UserNotFoundException ex) {
		
		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
				.withStatus(HttpStatus.NOT_FOUND)
				.withError_code(HttpStatus.NOT_FOUND.name())
				.withMessage(ex.getLocalizedMessage())
				.build();
		return new ResponseEntity<>(response, response.getStatus());
	}
	
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<?> handleAuth(AuthenticationException ex) {
		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
				.withStatus(HttpStatus.UNAUTHORIZED)
				.withError_code(HttpStatus.UNAUTHORIZED.name())
				.withMessage("Bad Credentials!")
				.build();
		return new ResponseEntity<>(response, response.getStatus());
	}
}
