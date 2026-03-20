package lk.ijse.orderservice.service.impl;

import lk.ijse.orderservice.client.CustomerServiceClient;
import lk.ijse.orderservice.client.FoodServiceClient;
import lk.ijse.orderservice.dto.CustomerDTO;
import lk.ijse.orderservice.dto.FoodDto;
import lk.ijse.orderservice.dto.OrderDTO;
import lk.ijse.orderservice.entity.Order;
import lk.ijse.orderservice.exception.OrderNotFoundException;
import lk.ijse.orderservice.mapper.OrderMapper;
import lk.ijse.orderservice.repository.OrderRepository;
import lk.ijse.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final CustomerServiceClient customerClient;
    private final FoodServiceClient foodClient;

    @Override
    @Transactional
    public OrderDTO createOrder(OrderDTO dto) {

        log.debug("Creating order for {}", dto.getCustomerPhone());

        // ✅ Validate external services (same as Enrollment)
        CustomerDTO customer = customerClient.getCustomer(dto.getCustomerPhone());
        FoodDto food = foodClient.getFood(dto.getFoodId());

        Order order = mapper.toEntity(dto);

        order.setCustomerName(customer.getName());
        order.setFoodName(food.getName());
        order.setPrice(food.getPrice());
        order.setTotal(food.getPrice() * dto.getQty());
        order.setStatus("Pending");
        order.setDate(LocalDateTime.now());

        Order saved = repository.save(order);

        return mapper.toDto(saved);
    }

    @Override
    @Transactional
    public OrderDTO updateOrder(Long id, OrderDTO dto) {

        Order order = repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        mapper.updateEntity(dto, order);

        return mapper.toDto(repository.save(order));
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        repository.delete(order);
    }

    @Override
    public OrderDTO getOrder(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public OrderDTO updateStatus(Long id, String status) {

        Order order = repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        order.setStatus(status);

        return mapper.toDto(repository.save(order));
    }
}