package com.coolcoder.service;

import java.util.List;

import com.coolcoder.dto.UserDTO;

public interface UserService {
	UserDTO createUser(UserDTO dto);

	UserDTO getById(Long id);

	List<UserDTO> getAll();

	UserDTO updateUser(Long id, UserDTO dto);

	void deleteUser(Long id);
}
