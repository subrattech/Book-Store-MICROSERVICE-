package com.coolcoder.service;

import java.util.List;

import com.coolcoder.dto.BookDTO;

public interface BookService {
	BookDTO createBook(BookDTO bookDTO);

	BookDTO getBookById(Long id);

	List<BookDTO> getAllBooks();

	BookDTO updateBook(Long id, BookDTO bookDTO);

	void deleteBook(Long id);
}