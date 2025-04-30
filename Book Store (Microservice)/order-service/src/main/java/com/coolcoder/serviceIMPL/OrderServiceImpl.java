package com.coolcoder.serviceIMPL;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coolcoder.client.BookClient;
import com.coolcoder.client.UserClient;
import com.coolcoder.dto.BookDTO;
import com.coolcoder.dto.OrderDTO;
import com.coolcoder.dto.UserDTO;
import com.coolcoder.exception.ResourceNotFoundException;
import com.coolcoder.model.Order;
import com.coolcoder.repository.OrderRepository;
import com.coolcoder.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	private final OrderRepository repo;
	private final UserClient userClient;
	private final BookClient bookClient;

	private OrderDTO toDTO(Order order) {
		UserDTO user = userClient.getById(order.getUserId());
		BookDTO book = bookClient.getById(order.getBookId());

		return OrderDTO.builder().id(order.getId()).userId(order.getUserId()).bookId(order.getBookId()).user(user)
				.book(book).quantity(order.getQuantity()).orderDate(order.getOrderDate()).build();
	}

	private Order toEntity(OrderDTO dto) {
		return Order.builder().userId(dto.getUserId()).bookId(dto.getBookId()).quantity(dto.getQuantity())
				.orderDate(LocalDateTime.now()).build();
	}

	@Override
	@Transactional
	public OrderDTO placeOrder(OrderDTO dto) {
		UserDTO user = userClient.getById(dto.getUserId());
		if (user == null)
			throw new ResourceNotFoundException("User not found: " + dto.getUserId());
		BookDTO book = bookClient.getById(dto.getBookId());
		if (book == null)
			throw new ResourceNotFoundException("Book not found: " + dto.getBookId());

		Order saved = repo.save(toEntity(dto));
		return toDTO(saved);
	}

	@Override
	public OrderDTO getById(Long id) {
		Order order = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found: " + id));
		return toDTO(order);
	}

	@Override
	public List<OrderDTO> getAll() {
		return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void cancelOrder(Long id) {
		Order order = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found: " + id));
		repo.delete(order);
	}
}
