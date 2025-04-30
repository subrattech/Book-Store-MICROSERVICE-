package com.coolcoder.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coolcoder.dto.BookDTO;

@FeignClient(name = "BOOK-SERVICE", fallback = BookClientFallback.class, path = "/api/books")
public interface BookClient {
	@GetMapping("/{id}")
	BookDTO getById(@PathVariable("id") Long id);
}
