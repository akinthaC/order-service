package lk.ijse.orderservice.client;

import lk.ijse.orderservice.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class CustomerClient {

    private final RestClient restClient;

    public CustomerDTO getCustomerByPhone(String phone) {
        return restClient.get()
                .uri("http://CUSTOMER-SERVICE/api/v1/customers/phone/{phone}", phone)
                .retrieve()
                .body(CustomerDTO.class);
    }
}