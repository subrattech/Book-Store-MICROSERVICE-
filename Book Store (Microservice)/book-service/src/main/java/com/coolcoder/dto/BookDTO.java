package com.coolcoder.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookDTO {

	private Long id;

	@NotNull
	private String title;

	@NotNull
	private String author;

	@NotNull
	private Double price;

	@NotNull
	private Date publishedDate;
}
