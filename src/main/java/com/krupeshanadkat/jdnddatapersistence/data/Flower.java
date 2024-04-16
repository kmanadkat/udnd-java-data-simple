package com.krupeshanadkat.jdnddatapersistence.data;

import jakarta.persistence.*;

@Entity
public class Flower extends Plant {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
