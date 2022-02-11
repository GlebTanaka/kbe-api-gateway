package de.htwberlin.f4.apigateway.services;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GatewayService {

    private final String productApi = "http://host.docker.internal:8080/api/v1/product";
    private final String calculatorApi = "http://host.docker.internal:8081/api/v1/calculator";

    public Double getMehrwertsteuer(double price) {
        final String uri = calculatorApi + "/calculatemehrwertsteuer?preis=" + price;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, Double.class);
    }

    public Object getProducts() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(productApi, Object.class);
    }

    public Object getProduct(UUID id) {
        final String uri = productApi + "/" + id;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, Object.class);
    }
}
