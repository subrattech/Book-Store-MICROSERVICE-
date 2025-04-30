package com.coolcoder.serviceIMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.coolcoder.dto.UserDTO;
import com.coolcoder.exception.EmailAlreadyExistsException;
import com.coolcoder.exception.ResourceNotFoundException;
import com.coolcoder.model.User;
import com.coolcoder.repository.UserRepository;
import com.coolcoder.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository repo;

	private UserDTO toDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		return dto;
	}

	private User toEntity(UserDTO dto) {
		User user = new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		return user;
	}

	@Override
	@Transactional
	public UserDTO createUser(UserDTO dto) {
		if (repo.existsByEmail(dto.getEmail())) {
			throw new EmailAlreadyExistsException("Email already in use: " + dto.getEmail());
		}
		User saved = repo.save(toEntity(dto));
		return toDTO(saved);
	}

	@Override
	public UserDTO getById(Long id) {
		User user = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
		return toDTO(user);
	}

	@Override
	public List<UserDTO> getAll() {
		return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public UserDTO updateUser(Long id, UserDTO dto) {
		User existing = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

		if (dto.getEmail() != null && !dto.getEmail().equals(existing.getEmail())) {
			if (repo.existsByEmail(dto.getEmail())) {
				throw new EmailAlreadyExistsException("Email already in use: " + dto.getEmail());
			}
			existing.setEmail(dto.getEmail());
		}
		if (dto.getName() != null) {
			existing.setName(dto.getName());
		}
		if (dto.getPassword() != null) {
			existing.setPassword(dto.getPassword());
		}

		User updated = repo.save(existing);
		return toDTO(updated);
	}

	@Override
	@Transactional
	public void deleteUser(Long id) {
		User existing = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
		repo.delete(existing);
	}
}
