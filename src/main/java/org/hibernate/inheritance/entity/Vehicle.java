package org.hibernate.inheritance.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "vehicle"
//        ,discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@NoArgsConstructor
public class Vehicle {
    @Id @GeneratedValue
    private Integer Id;
    private String VehicleName;

    public Vehicle(String vehicleName) {
        VehicleName = vehicleName;
    }
}
