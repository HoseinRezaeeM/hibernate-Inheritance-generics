package org.hibernate.inheritance;

import org.hibernate.Session;
import org.hibernate.inheritance.config.SessionFactoryProvider;
import org.hibernate.inheritance.entity.FourWheeler;
import org.hibernate.inheritance.entity.TwoWheeler;
import org.hibernate.inheritance.entity.Vehicle;
import org.hibernate.query.Query;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Vehicle vehicle =new Vehicle("Car");
        TwoWheeler vehicleTwo =new TwoWheeler("Motor","bmw");
        FourWheeler vehicleFour =new FourWheeler("Porshe","benz");




        final Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            final Vehicle vehicle1 = session.get(Vehicle.class, 2);
            System.out.println(vehicle1);
            session.save(vehicle);
            session.save(vehicleTwo);
            session.save(vehicleFour);
           // String id ="1";
            final Query query = session.createQuery("SELECT Id FROM Vehicle where Id=:i");
           query.setParameter("i","1");
            final int i = query.executeUpdate();
            System.out.println(i);
            // query.setFirstResult(1);   //first data
          //  query.setMaxResults(2);   // max data
        //   final List<String> list = query.list();
//            for (String v: list){
//                System.out.println(v);
//            }
       //    System.out.println(list);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }
}
