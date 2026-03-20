package lk.ijse.orderservice.mapper;

import lk.ijse.orderservice.dto.OrderDTO;
import lk.ijse.orderservice.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order toEntity(OrderDTO dto) {
        return Order.builder()
                .id(dto.getId())
                .customerPhone(dto.getCustomerPhone())
                .customerName(dto.getCustomerName())
                .foodId(dto.getFoodId())
                .foodName(dto.getFoodName())
                .tableNo(dto.getTableNo())
                .qty(dto.getQty())
                .price(dto.getPrice())
                .total(dto.getTotal())
                .status(dto.getStatus())
                .date(dto.getDate())
                .build();
    }

    public OrderDTO toDto(Order entity) {
        return OrderDTO.builder()
                .id(entity.getId())
                .customerPhone(entity.getCustomerPhone())
                .customerName(entity.getCustomerName())
                .foodId(entity.getFoodId())
                .foodName(entity.getFoodName())
                .tableNo(entity.getTableNo())
                .qty(entity.getQty())
                .price(entity.getPrice())
                .total(entity.getTotal())
                .status(entity.getStatus())
                .date(entity.getDate())
                .build();
    }

    public void updateEntity(OrderDTO dto, Order entity) {
        entity.setCustomerPhone(dto.getCustomerPhone());
        entity.setCustomerName(dto.getCustomerName());
        entity.setFoodId(dto.getFoodId());
        entity.setTableNo(dto.getTableNo());
        entity.setQty(dto.getQty());
        entity.setPrice(dto.getPrice());
        entity.setTotal(dto.getQty() * dto.getPrice());
        entity.setStatus(dto.getStatus());
    }
}