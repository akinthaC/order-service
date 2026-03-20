package lk.ijse.orderservice.mapper;

import lk.ijse.orderservice.dto.OrderDTO;
import lk.ijse.orderservice.entity.OrderEntity;

public class OrderMapper {

    public static OrderDTO toDTO(OrderEntity entity) {
        return OrderDTO.builder()
                .id(entity.getId())
                .customerName(entity.getCustomerName())
                .customerPhone(entity.getCustomerPhone())
                .tableNo(entity.getTableNo())
                .foodId(entity.getFoodId())
                .foodName(entity.getFoodName())
                .qty(entity.getQty())
                .price(entity.getPrice())
                .total(entity.getTotal())
                .status(entity.getStatus())
                .date(entity.getDate())
                .build();
    }

    public static OrderEntity toEntity(OrderDTO dto) {
        return OrderEntity.builder()
                .id(dto.getId())
                .customerName(dto.getCustomerName())
                .customerPhone(dto.getCustomerPhone())
                .tableNo(dto.getTableNo())
                .foodId(dto.getFoodId())
                .foodName(dto.getFoodName())
                .qty(dto.getQty())
                .price(dto.getPrice())
                .total(dto.getTotal())
                .status(dto.getStatus())
                .date(dto.getDate())
                .build();
    }
}