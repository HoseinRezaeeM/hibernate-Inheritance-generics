package org.hibernate.inheritance;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.inheritance.config.SessionFactoryProvider;
import org.hibernate.inheritance.entity.FourWheeler;
import org.hibernate.inheritance.entity.TwoWheeler;
import org.hibernate.inheritance.entity.User;
import org.hibernate.inheritance.entity.Vehicle;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {


        TwoWheeler vehicleTwo = new TwoWheeler("bmw");
        FourWheeler vehicleFour = new FourWheeler("benz");
        List<Vehicle> list = Arrays.asList(vehicleTwo, vehicleFour);
        User user = new User(null, "Hosein", list);


        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        try {
        session.beginTransaction();
//        //    final Vehicle vehicle1 = session.get(Vehicle.class, 2);
//          //  System.out.println(vehicle1);
////            session.save(vehicle);
////            session.save(vehicleTwo);
////            session.save(vehicleFour);
        session.save(user);

//           // String id ="1";
////            final TypedQuery query = session.createQuery("UPDATE FROM Vehicle SET VehicleName=:v where Id=:i");
////            query.setParameter("v","xanzi");
////           query.setParameter("i",43);
////           query.executeUpdate();
        Criteria criteria = session.createCriteria(User.class)
                .setProjection(Projections.max("id"));
        //criteria.add(Restrictions.eq("name", "Hosein"));
      //  criteria.add(Restrictions.or(Restrictions.between("id",0,1),Restrictions.between("id",1,3)));
       // criteria.add(Restrictions.gt("id",2));
        final List list3 = criteria.list();
        System.out.println(list3);

//            // query.setFirstResult(1);   //first data
//          //  query.setMaxResults(2);   // max data
//        //   final List<String> list = query.list();
////            for (String v: list){
////                System.out.println(v);
////            }
//       //    System.out.println(list);
        session.getTransaction().commit();
//        }catch (Exception e){
//            e.printStackTrace();
//            session.getTransaction().rollback();
//        }
//        final Query select_u_from_user_u = session.createQuery("select u from User u");
//        final List<User> list1 = select_u_from_user_u.list();
//        System.out.println(list1);
        final Query namedQuery = session.getNamedQuery("user.byid");
        namedQuery.setParameter("id", 1);
        final List list1 = namedQuery.list();
        System.out.println(list1);


        final Query namedQuery1 = session.getNamedNativeQuery("user.byname");
        namedQuery1.setParameter("name", "Hosein");
        final List list2 = namedQuery1.list();
        System.out.println(list2);


    }


}
