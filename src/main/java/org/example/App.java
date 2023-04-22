package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Address a1=new Address();
        Address a2=new Address();
        Student s1=new Student();
       s1.setId(203);
       s1.setName("shankar");

       a1.setId(101);
        a2.setId(102);

       a1.setCity("hyd");
       a2.setCity("bgl");

       a1.setCountry("ind");
       a2.setCountry(a1.getCountry());

       a1.setState("ts");
       a2.setState("ka");

       a1.setStudent(s1);
       a2.setStudent(s1);
        List<Address> add=Arrays.asList(a1,a2);

        s1.setAddressList(add);

        a1.setStudent(s1);//bi directional
        a2.setStudent(s1);


        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(s1);// parent and child same operation then use cascade=Cascade.ALL
        //else
        //session.save(a1); and session.save(a2);

           transaction.commit();
     //   System.out.println("One to many mapping succesfully done by directionally...");
        session.close();
       sessionFactory.close();
    }
}
