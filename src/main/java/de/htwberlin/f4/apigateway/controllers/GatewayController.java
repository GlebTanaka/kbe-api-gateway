package de.htwberlin.f4.apigateway.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.htwberlin.f4.apigateway.services.GatewayService;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "api/v1/gateway")
public class GatewayController {

    @Autowired
    private GatewayService gateway;

    @GetMapping("/calculatemehrwertsteuer")
    public ResponseEntity<Double> getMehrwertSteuer(@RequestParam double preis){
        return ResponseEntity.ok(gateway.getMehrwertsteuer(preis));
    }

    @GetMapping("/product")
    public ResponseEntity<Object> getProducts(){
        return ResponseEntity.ok(gateway.getProducts());
    }

    @GetMapping("/product/{uuid}")
    public ResponseEntity<Object> getProduct(@PathVariable UUID uuid){
        return ResponseEntity.ok(gateway.getProduct(uuid));
    }

    @GetMapping("product/export")
    public ResponseEntity<Object> exportProduct(){
        gateway.exportProduct();
        return ResponseEntity.ok(null);
    }
    
}
