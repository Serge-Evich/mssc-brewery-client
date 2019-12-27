package microserivces.msscbreweryclient.web.client;

import microserivces.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "mssc.brewery.client", ignoreUnknownFields = false)
public class CustomerBreweryClient {

    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apiHost;
    private final RestTemplate restTemplate;

    public CustomerBreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public CustomerDto get(UUID customerId) {
        return restTemplate.getForObject(getUrl() + customerId, CustomerDto.class);
    }

    public URI create(CustomerDto customerDto) {
        return restTemplate.postForLocation(getUrl(), customerDto);
    }

    public void update(UUID id, CustomerDto customerDto) {
        restTemplate.put(getUrl() + id, customerDto);
    }

    public void delete(UUID id) {
        restTemplate.delete(getUrl() + id);
    }

    private String getUrl() {
        return apiHost + CUSTOMER_PATH_V1;
    }
}
