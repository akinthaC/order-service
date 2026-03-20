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
    public OrderDTO create(@RequestBody OrderDTO dto) {
        return service.createOrder(dto);
    }

    @GetMapping
    public List<OrderDTO> getAll() {
        return service.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderDTO get(@PathVariable Long id) {
        return service.getOrder(id);
    }

    @PutMapping("/{id}")
    public OrderDTO update(@PathVariable Long id, @RequestBody OrderDTO dto) {
        return service.updateOrder(id, dto);
    }

    @PutMapping("/{id}/status")
    public OrderDTO updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteOrder(id);
    }
}