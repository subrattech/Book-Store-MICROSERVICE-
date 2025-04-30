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

import com.coolcoder.dto.UserDTO;
import com.coolcoder.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService svc;

	@PostMapping
	public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO d) {
		return ResponseEntity.ok(svc.createUser(d));
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> get(@PathVariable Long id) {
		return ResponseEntity.ok(svc.getById(id));
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> all() {
		return ResponseEntity.ok(svc.getAll());
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable Long id, @Valid @RequestBody UserDTO d) {
		return ResponseEntity.ok(svc.updateUser(id, d));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		svc.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
