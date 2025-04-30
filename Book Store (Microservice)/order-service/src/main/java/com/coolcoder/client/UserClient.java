package com.coolcoder.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coolcoder.dto.UserDTO;

@FeignClient(name = "USER-SERVICE", fallback = UserClientFallback.class, path = "/api/users")
public interface UserClient {
	@GetMapping("/{id}")
	UserDTO getById(@PathVariable("id") Long id);
}
