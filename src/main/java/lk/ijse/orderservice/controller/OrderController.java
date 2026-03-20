package lk.ijse.orderservice.controller;

import lk.ijse.orderservice.dto.OrderDTO;
import lk.ijse.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {

    private final OrderService service;

    @PostMapping
    public OrderDTO placeOrder(@RequestBody OrderDTO dto) {
        return service.placeOrder(dto);
    }

    @GetMapping
    public List<OrderDTO> getAll() {
        return service.getAllOrders();
    }

    @GetMapping("/phone/{phone}")
    public List<OrderDTO> getByPhone(@PathVariable String phone) {
        return service.getOrdersByPhone(phone);
    }

    @PutMapping("/{id}/status")
    public OrderDTO updateStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        return service.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteOrder(id);
    }
}