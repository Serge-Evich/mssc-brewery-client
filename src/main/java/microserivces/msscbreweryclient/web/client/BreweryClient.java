package microserivces.msscbreweryclient.web.client;

import microserivces.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "mssc.brewery.client", ignoreUnknownFields = false)
public class BreweryClient {
    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apiHost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public BeerDto getById(UUID id) {
        return restTemplate.getForObject(getUrl() + id, BeerDto.class);
    }

    private String getUrl() {
        return apiHost + BEER_PATH_V1;
    }

    public URI create(BeerDto beerDto) {
        return restTemplate.postForLocation(getUrl(), beerDto);
    }

    public void update(UUID id, BeerDto beerDto) {
        restTemplate.put(getUrl() + id, beerDto);
    }

    public void delete(UUID id) {
        restTemplate.delete(getUrl() + id);
    }
}
