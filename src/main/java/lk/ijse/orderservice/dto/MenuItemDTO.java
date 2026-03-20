package lk.ijse.foodservice.dto;

import jakarta.validation.constraints.*;
import lk.ijse.foodservice.validation.ValidImage;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuItemDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Price is required")
    private Double price;

    @NotNull(message = "Category is required")
    private Long categoryId;

    // 🔥 USE YOUR CUSTOM VALIDATOR HERE
    @ValidImage
    private MultipartFile image;
}