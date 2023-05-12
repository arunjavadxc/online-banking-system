package com.banking.user.utils;

import lombok.Data;

@Data
public class ResponseWrapper<T> {

	public Response<T> wrapResponse(T t, String message, int statusCode) {
		Response<T> response = new Response<>();
		response.setResponseObj(t);
		response.setMessage(message);
		response.setStatusCode(statusCode);
		return response;
	}

}
