package microserivces.msscbreweryclient.web.client;

import microserivces.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    private BreweryClient breweryClient;

    @Test
    void getById() {
        BeerDto beerDto = breweryClient.getById(UUID.randomUUID());
        assertThat(beerDto).isNotNull();
    }
}