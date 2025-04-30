package com.coolcoder.service;

import java.util.List;

import com.coolcoder.dto.OrderDTO;

public interface OrderService {
	OrderDTO placeOrder(OrderDTO dto);

	OrderDTO getById(Long id);

	List<OrderDTO> getAll();

	void cancelOrder(Long id);
}