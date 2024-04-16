package com.krupeshanadkat.jdnddatapersistence.service;

import com.krupeshanadkat.jdnddatapersistence.data.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService {
    public Plant getPlantByName(String name){
        return new Plant();
    }
}
