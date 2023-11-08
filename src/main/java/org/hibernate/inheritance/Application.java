package org.hibernate.inheritance;

import org.hibernate.Session;
import org.hibernate.inheritance.config.SessionFactoryProvider;
import org.hibernate.inheritance.entity.FourWheeler;
import org.hibernate.inheritance.entity.TwoWheeler;
import org.hibernate.inheritance.entity.Vehicle;

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
          //  session.delete(vehicle);
            session.save(vehicleTwo);
            session.save(vehicleFour);
            vehicleTwo.setVehicleName("toyota");
            session.update(vehicleTwo);


            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }
}
