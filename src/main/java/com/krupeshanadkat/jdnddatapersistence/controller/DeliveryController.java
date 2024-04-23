package com.krupeshanadkat.jdnddatapersistence.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.krupeshanadkat.jdnddatapersistence.data.Delivery;
import com.krupeshanadkat.jdnddatapersistence.data.Plant;
import com.krupeshanadkat.jdnddatapersistence.data.RecipientAndPrice;
import com.krupeshanadkat.jdnddatapersistence.service.DeliveryService;
import com.krupeshanadkat.jdnddatapersistence.service.PlantService;
import com.krupeshanadkat.jdnddatapersistence.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;

    @Autowired
    PlantService plantService;

    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery) {
        return deliveryService.save(delivery);
    }

    @GetMapping("/bill/{deliveryId}")
    public RecipientAndPrice getBill(@PathVariable Long deliveryId) {
        return deliveryService.getBill(deliveryId);
    }

    @GetMapping("/delivered/{id}")
    public Boolean delivered(@PathVariable Long id) {
        return plantService.delivered(id);
    }

    @GetMapping("/under-price/{price}")
    @JsonView(Views.Public.class)
    public List<Plant> plantsCheaperThan(@PathVariable BigDecimal price) {
        return plantService.findPlantsBelowPrice(price);
    }
}
