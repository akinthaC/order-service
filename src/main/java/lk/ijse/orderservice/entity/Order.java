package lk.ijse.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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