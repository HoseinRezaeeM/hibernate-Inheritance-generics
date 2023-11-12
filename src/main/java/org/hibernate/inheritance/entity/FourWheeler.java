package org.hibernate.inheritance.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
//@DiscriminatorValue("Car")
@Setter
@Getter
@NoArgsConstructor
public class FourWheeler extends Vehicle<Integer> {
   // @JoinTable(name = "twoheel",joinColumns = @JoinColumn(name = "TwoId"),inverseJoinColumns =@JoinColumn(name = "streeHndler"))
    private String streeHandler;

    public FourWheeler(String streeHandler) {
        this.streeHandler = streeHandler;
    }
}
