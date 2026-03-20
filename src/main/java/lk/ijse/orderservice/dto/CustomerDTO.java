package lk.ijse.customerservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private String id;
    private String name;
    private String email;
    private String phone;
}