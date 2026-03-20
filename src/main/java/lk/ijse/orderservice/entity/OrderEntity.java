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
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String customerPhone;
    private String tableNo;

    private Long foodId;
    private String foodName;

    private int qty;
    private double price;
    private double total;

    private String status; // Pending, Cooking, Done

    private LocalDateTime date;
}