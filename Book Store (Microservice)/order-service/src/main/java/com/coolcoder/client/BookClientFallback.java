package com.coolcoder.client;

import org.springframework.stereotype.Component;

import com.coolcoder.dto.BookDTO;
import com.coolcoder.exception.ResourceNotFoundException;

@Component
public class BookClientFallback implements BookClient {
	@Override
	public BookDTO getById(Long id) {
		throw new ResourceNotFoundException("Book service unavailable – cannot fetch book " + id);
	}
}
