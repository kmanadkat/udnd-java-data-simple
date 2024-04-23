package com.krupeshanadkat.jdnddatapersistence.service;

import com.krupeshanadkat.jdnddatapersistence.data.Delivery;
import com.krupeshanadkat.jdnddatapersistence.data.RecipientAndPrice;
import com.krupeshanadkat.jdnddatapersistence.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public RecipientAndPrice getBill(Long deliveryId){
        return deliveryRepository.getBill(deliveryId);
    }

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }
}
