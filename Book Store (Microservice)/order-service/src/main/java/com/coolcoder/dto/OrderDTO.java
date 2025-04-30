package com.coolcoder.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
	private Long id;

	private Long userId;
	private Long bookId;

	private UserDTO user;
	private BookDTO book;

	@NotNull
	@Min(value = 1, message = "Quantity must be at least 1")
	private Integer quantity;

	private LocalDateTime orderDate;
}
