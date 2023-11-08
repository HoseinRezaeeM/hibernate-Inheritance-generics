package org.hibernate.inheritance.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicle")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "vehicle"
//        ,discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Vehicle<ID extends Serializable> {
    @Id @GeneratedValue
    private Integer Id;
    private String VehicleName;

    public Vehicle(String vehicleName) {
        VehicleName = vehicleName;
    }
}
