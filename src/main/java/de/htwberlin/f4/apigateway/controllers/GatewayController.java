package de.htwberlin.f4.apigateway.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import de.htwberlin.f4.apigateway.services.GatewayService;

import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

@Validated
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(path = "api/v1/gateway")
public class GatewayController {

    private final GatewayService gateway;

    @Autowired
    public GatewayController(GatewayService gateway) {
        this.gateway = gateway;
    }

    @GetMapping("/calculatemehrwertsteuer")
    @Operation(summary = "Calculate Mehrwersteuer", description = "Provide a price greater than zero to calculate the Mehrwertstuer of this price")
    public ResponseEntity<Double> getMehrwertSteuer(@RequestParam @NotNull @Min(0) double preis){
        return ResponseEntity.ok(gateway.getMehrwertsteuer(preis));
    }

    @GetMapping("/product")
    @Operation(summary = "Get Product List", description = "A List of all Products containing the name and ID")
    public ResponseEntity<Object> getProducts(){
        return ResponseEntity.ok(gateway.getProducts());
    }

    @GetMapping("/product/{uuid}")
    @Operation(summary = "Get Product Information", description = "Provide a matching UUID to retrieve Information of the Product")
    public ResponseEntity<Object> getProduct(@PathVariable UUID uuid){
        return ResponseEntity.ok(gateway.getProduct(uuid));
    }
}
