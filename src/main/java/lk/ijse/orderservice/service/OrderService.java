package lk.ijse.orderservice.service;

import lk.ijse.orderservice.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO placeOrder(OrderDTO dto);

    List<OrderDTO> getAllOrders();

    List<OrderDTO> getOrdersByPhone(String phone);

    OrderDTO updateStatus(Long id, String status);

    void deleteOrder(Long id);
}