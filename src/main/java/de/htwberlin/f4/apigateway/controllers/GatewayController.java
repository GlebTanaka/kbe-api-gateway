package de.htwberlin.f4.apigateway.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.htwberlin.f4.apigateway.services.GatewayService;

import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

@Validated
@RestController
@RequestMapping(path = "api/v1/gateway")
public class GatewayController {

    @Autowired
    private GatewayService gateway;

    /**
     * liefert die Mehrwertsteuer zum Preis
     * @param preis als double
     * @return ResponseEntity<Double> enthält die Mehrwertsteuer
     */
    @GetMapping("/calculatemehrwertsteuer")
    public ResponseEntity<Double> getMehrwertSteuer(@RequestParam @NotNull @Min(0) double preis){
        return ResponseEntity.ok(gateway.getMehrwertsteuer(preis));
    }

    /**
     * Liefert alle Produkte von dem application microservice
     * @return ResponseEntity<Object> produkte
     */
    @GetMapping("/product")
    public ResponseEntity<Object> getProducts(){
        return ResponseEntity.ok(gateway.getProducts());
    }

    /**
     * Liefert alle Produktdeteils von einem Produkt
     * @param uuid des ausgewählten Produkts
     * @return ResponseEntity<Object> alle Produktdeteils
     */
    @GetMapping("/product/{uuid}")
    public ResponseEntity<Object> getProduct(@PathVariable UUID uuid){
        return ResponseEntity.ok(gateway.getProduct(uuid));
    }

    /**
     * CSV Export in der Application
     * @return leeres ResponseEntity<Object>
     */
    @GetMapping("product/export")
    public ResponseEntity<Object> exportProduct(){
        gateway.exportProduct();
        return ResponseEntity.ok(null);
    }
    
}
