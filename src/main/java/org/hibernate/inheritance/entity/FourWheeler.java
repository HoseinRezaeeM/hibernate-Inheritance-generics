package org.hibernate.inheritance.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class FourWheeler extends Vehicle {
    private String streeHandler;


    public FourWheeler(String vehicleName, String streeHandler) {
        super(vehicleName);
        this.streeHandler = streeHandler;
    }
}
