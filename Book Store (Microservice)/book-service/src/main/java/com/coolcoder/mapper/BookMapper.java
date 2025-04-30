package com.coolcoder.mapper;

import org.springframework.stereotype.Component;

import com.coolcoder.dto.BookDTO;
import com.coolcoder.model.Book;

@Component
public class BookMapper {

	public Book toEntity(BookDTO bookDTO) {
		Book book = new Book();
		book.setTitle(bookDTO.getTitle());
		book.setAuthor(bookDTO.getAuthor());
		book.setPrice(bookDTO.getPrice());
		book.setPublishedDate(bookDTO.getPublishedDate());
		return book;
	}

	public BookDTO toDTO(Book book) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(book.getId());
		bookDTO.setTitle(book.getTitle());
		bookDTO.setAuthor(book.getAuthor());
		bookDTO.setPrice(book.getPrice());
		bookDTO.setPublishedDate(book.getPublishedDate());
		return bookDTO;
	}

	public void updateEntityFromDTO(BookDTO bookDTO, Book book) {
		if (bookDTO.getTitle() != null) {
			book.setTitle(bookDTO.getTitle());
		}
		if (bookDTO.getAuthor() != null) {
			book.setAuthor(bookDTO.getAuthor());
		}
		if (bookDTO.getPrice() != null) {
			book.setPrice(bookDTO.getPrice());
		}
		if (bookDTO.getPublishedDate() != null) {
			book.setPublishedDate(bookDTO.getPublishedDate());
		}
	}
}
