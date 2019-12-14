package microserivces.msscbreweryclient.web.client;

import microserivces.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
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

    @Test
    public void createBeer() {
        BeerDto beerDto = BeerDto.builder()
                .beerName("beer name")
                .beerStyle("Beer style")
                .build();

        URI beerLocation = breweryClient.create(beerDto);

        assertThat(beerLocation).isNotNull();
    }

    @Test
    void update() {
        BeerDto beerDto = BeerDto.builder()
                .beerStyle("Changed style")
                .beerName("Changed name")
                .upc(321L)
                .build();

        breweryClient.update(UUID.randomUUID(), beerDto);
    }

    @Test
    void delete() {
        breweryClient.delete(UUID.randomUUID());
    }
}