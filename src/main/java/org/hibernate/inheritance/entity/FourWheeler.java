package org.hibernate.inheritance.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Car")
@Setter
@Getter
@NoArgsConstructor
public class FourWheeler extends Vehicle<Integer> {
    private String streeHandler;


    public FourWheeler(String vehicleName, String streeHandler) {
        super(vehicleName);
        this.streeHandler = streeHandler;
    }
}
