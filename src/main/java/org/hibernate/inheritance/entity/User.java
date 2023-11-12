package org.hibernate.inheritance.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@ToString
@NamedQuery(name = "user.byid",query = "SELECT u FROM User u WHERE id > :id")
@NamedNativeQuery(name = "user.byname",query = "SELECT * FROM postgres.public.users WHERE name=:name",resultClass = User.class)
public class User {
    @Id @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "users_vehicle" ,joinColumns = @JoinColumn(name = "user_id")
            ,inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    private List<Vehicle> list;
}
