package lk.ijse.orderservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

    private Long id;

    private String customerPhone;
    private String customerName;

    private Long foodId;
    private String foodName;

    private String tableNo;

    private int qty;
    private double price;
    private double total;

    private String status;

    private LocalDateTime date;
}