package microserivces.msscbreweryclient.web.client;

import microserivces.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class CustomerBreweryClientTest {

    @Autowired
    private CustomerBreweryClient customerBreweryClient;

    @Test
    void get() {
        assertThat(customerBreweryClient.get(UUID.randomUUID())).isNotNull();
    }

    @Test
    void create() {
        CustomerDto customerDto = CustomerDto.builder().name("some name").build();
        URI uri = customerBreweryClient.create(customerDto);
        assertThat(uri).isNotNull();
    }

    @Test
    void update() {
        CustomerDto customerDto = CustomerDto.builder().name("some name").build();
        customerBreweryClient.update(UUID.randomUUID(), customerDto);
    }

    @Test
    void delete() {
        customerBreweryClient.delete(UUID.randomUUID());
    }
}