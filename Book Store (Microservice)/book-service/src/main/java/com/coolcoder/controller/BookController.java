// === controller/BookController.java ===
package com.coolcoder.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coolcoder.dto.BookDTO;
import com.coolcoder.service.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

	private final BookService bookService;

	@PostMapping
	public ResponseEntity<BookDTO> create(@Valid @RequestBody BookDTO bookDTO) {
		return ResponseEntity.ok(bookService.createBook(bookDTO));
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookDTO> get(@PathVariable Long id) {
		return ResponseEntity.ok(bookService.getBookById(id));
	}

	@GetMapping
	public ResponseEntity<List<BookDTO>> getAll() {
		return ResponseEntity.ok(bookService.getAllBooks());
	}

	@PutMapping("/{id}")
	public ResponseEntity<BookDTO> update(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO) {
		return ResponseEntity.ok(bookService.updateBook(id, bookDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		bookService.deleteBook(id);
		return ResponseEntity.noContent().build();
	}
}
