package org.hibernate.inheritance.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Bike")
@Getter
@Setter
@NoArgsConstructor
public class TwoWheeler extends Vehicle<Integer> {
    private String streeingHandler;



    public TwoWheeler( String streeingHandler) {
        this.streeingHandler = streeingHandler;
    }
}
