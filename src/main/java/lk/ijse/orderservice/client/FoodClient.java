package lk.ijse.orderservice.client;

import lk.ijse.orderservice.dto.MenuItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class FoodClient {

    private final RestClient restClient;

    public MenuItemDTO getFood(Long id) {
        return restClient.get()
                .uri("http://FOOD-SERVICE/api/v1/foods/{id}", id)
                .retrieve()
                .body(MenuItemDTO.class);
    }
}