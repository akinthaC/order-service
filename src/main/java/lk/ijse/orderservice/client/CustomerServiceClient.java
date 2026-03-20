package lk.ijse.orderservice.client;

import lk.ijse.orderservice.dto.CustomerDTO;
import lk.ijse.orderservice.exception.CustomerServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@Slf4j
public class CustomerServiceClient {

    private final RestClient restClient;

    public CustomerServiceClient(@LoadBalanced RestClient.Builder builder) {
        this.restClient = builder.baseUrl("http://CUSTOMER-SERVICE").build();
    }

    public CustomerDTO getCustomer(String phone) {
        try {
            return restClient.get()
                    .uri("/api/v1/customers/phone/{phone}", phone)
                    .retrieve()
                    .body(CustomerDTO.class);
        } catch (Exception e) {
            log.error("Customer fetch failed", e);
            throw new CustomerServiceException("Customer not found", e);
        }
    }
}