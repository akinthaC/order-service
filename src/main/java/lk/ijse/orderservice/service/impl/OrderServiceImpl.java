package lk.ijse.orderservice.service.impl;

import lk.ijse.orderservice.dto.OrderDTO;
import lk.ijse.orderservice.entity.OrderEntity;
import lk.ijse.orderservice.exception.OrderServiceException;
import lk.ijse.orderservice.mapper.OrderMapper;
import lk.ijse.orderservice.repository.OrderRepository;
import lk.ijse.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    @Override
    public OrderDTO placeOrder(OrderDTO dto) {
        try {
            dto.setDate(LocalDateTime.now());
            dto.setStatus("Pending");

            OrderEntity saved = repository.save(OrderMapper.toEntity(dto));
            return OrderMapper.toDTO(saved);

        } catch (Exception e) {
            throw new OrderServiceException("Failed to place order", e);
        }
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return repository.findAll()
                .stream()
                .map(OrderMapper::toDTO)
                .toList();
    }

    @Override
    public List<OrderDTO> getOrdersByPhone(String phone) {
        return repository.findByCustomerPhone(phone)
                .stream()
                .map(OrderMapper::toDTO)
                .toList();
    }

    @Override
    public OrderDTO updateStatus(Long id, String status) {
        OrderEntity order = repository.findById(id)
                .orElseThrow(() -> new OrderServiceException("Order not found"));

        order.setStatus(status);
        return OrderMapper.toDTO(repository.save(order));
    }

    @Override
    public void deleteOrder(Long id) {
        if (!repository.existsById(id)) {
            throw new OrderServiceException("Order not found");
        }
        repository.deleteById(id);
    }
}