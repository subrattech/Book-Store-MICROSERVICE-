package com.coolcoder.serviceIMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.coolcoder.dto.BookDTO;
import com.coolcoder.exception.ResourceNotFoundException;
import com.coolcoder.mapper.BookMapper;
import com.coolcoder.model.Book;
import com.coolcoder.repository.BookRepository;
import com.coolcoder.service.BookService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	private final BookMapper bookMapper;

	@Override
	@Transactional
	public BookDTO createBook(BookDTO bookDTO) {
		Book book = bookMapper.toEntity(bookDTO);
		Book savedBook = bookRepository.save(book);
		return bookMapper.toDTO(savedBook);
	}

	@Override
	public BookDTO getBookById(Long id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
		return bookMapper.toDTO(book);
	}

	@Override
	public List<BookDTO> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		return books.stream().map(bookMapper::toDTO).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public BookDTO updateBook(Long id, BookDTO bookDTO) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
		bookMapper.updateEntityFromDTO(bookDTO, book);
		Book updatedBook = bookRepository.save(book);
		return bookMapper.toDTO(updatedBook);
	}

	@Override
	@Transactional
	public void deleteBook(Long id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
		bookRepository.delete(book);
	}
}