package lk.ijse.orderservice.service;

import lk.ijse.orderservice.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO createOrder(OrderDTO dto);

    OrderDTO updateOrder(Long id, OrderDTO dto);

    void deleteOrder(Long id);

    OrderDTO getOrder(Long id);

    List<OrderDTO> getAllOrders();

    OrderDTO updateStatus(Long id, String status);
}