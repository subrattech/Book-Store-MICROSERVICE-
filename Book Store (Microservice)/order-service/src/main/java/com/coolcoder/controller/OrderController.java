package com.coolcoder.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coolcoder.dto.OrderDTO;
import com.coolcoder.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
	private final OrderService service;

	@PostMapping
	public ResponseEntity<OrderDTO> place(@Valid @RequestBody OrderDTO dto) {
		return ResponseEntity.ok(service.placeOrder(dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderDTO> get(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@GetMapping
	public ResponseEntity<List<OrderDTO>> all() {
		return ResponseEntity.ok(service.getAll());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> cancel(@PathVariable Long id) {
		service.cancelOrder(id);
		return ResponseEntity.noContent().build();
	}
}
