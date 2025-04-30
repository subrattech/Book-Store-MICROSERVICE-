package com.coolcoder.client;

import org.springframework.stereotype.Component;

import com.coolcoder.dto.UserDTO;
import com.coolcoder.exception.ResourceNotFoundException;

@Component
public class UserClientFallback implements UserClient {
	@Override
	public UserDTO getById(Long id) {
		throw new ResourceNotFoundException("User service unavailable – cannot fetch user " + id);
	}
}
