package lk.ijse.orderservice.client;

import lk.ijse.orderservice.dto.FoodDto;
import lk.ijse.orderservice.exception.FoodServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@Slf4j
public class FoodServiceClient {

    private final RestClient restClient;

    public FoodServiceClient(@LoadBalanced RestClient.Builder builder) {
        this.restClient = builder.baseUrl("http://FOOD-SERVICE").build();
    }

    public FoodDto getFood(Long id) {
        try {
            return restClient.get()
                    .uri("/api/v1/foods/{id}", id)
                    .retrieve()
                    .body(FoodDto.class);
        } catch (Exception e) {
            log.error("Food fetch failed", e);
            throw new FoodServiceException("Food not found", e);
        }
    }
}