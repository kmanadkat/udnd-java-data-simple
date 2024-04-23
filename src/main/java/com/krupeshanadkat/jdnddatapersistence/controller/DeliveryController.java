package com.krupeshanadkat.jdnddatapersistence.controller;


import com.krupeshanadkat.jdnddatapersistence.data.Delivery;
import com.krupeshanadkat.jdnddatapersistence.data.RecipientAndPrice;
import com.krupeshanadkat.jdnddatapersistence.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;

    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery) {
        return deliveryService.save(delivery);
    }

    @GetMapping("/bill/{deliveryId}")
    public RecipientAndPrice getBill(@PathVariable Long deliveryId) {
        return deliveryService.getBill(deliveryId);
    }
}
