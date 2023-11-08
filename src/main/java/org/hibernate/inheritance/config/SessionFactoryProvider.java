package org.hibernate.inheritance.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.inheritance.entity.FourWheeler;
import org.hibernate.inheritance.entity.TwoWheeler;
import org.hibernate.inheritance.entity.Vehicle;

public class SessionFactoryProvider {

    public static final SessionFactory sessionFactory;

    static{
        StandardServiceRegistry standardServiceRegistry =new StandardServiceRegistryBuilder()
                .configure()
                .build();

        sessionFactory = new MetadataSources(standardServiceRegistry)
                .addAnnotatedClass(Vehicle.class)
                .addAnnotatedClass(TwoWheeler.class)
                .addAnnotatedClass(FourWheeler.class)
                .buildMetadata()
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
