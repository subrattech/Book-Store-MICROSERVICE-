// package com.coolcoder.dto;
package com.coolcoder.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {
	private Long id;

	@NotBlank(message = "Name required")
	private String name;

	@Email(message = "Valid email required")
	private String email;

	@NotBlank(message = "Password required")
	private String password;
}
