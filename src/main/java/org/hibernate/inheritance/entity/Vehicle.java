package org.hibernate.inheritance.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@NoArgsConstructor
public class Vehicle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String VehicleName;

    public Vehicle(String vehicleName) {
        VehicleName = vehicleName;
    }
}
