package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
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
       Address address=new Address(101, "HYD","TS","IND");
        Address address1=new Address(102, "BGL","KA","IND");
        List<Address> ls= Arrays.asList(address,address1);
        Student student=new Student(1,"shankar",ls);
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
       /* session.save(address);
        session.save(address1);
        session.save(student);
        */
        Student st=session.get(Student.class,1);
        for (Address a: st.getAddressList()
             ) {
            System.out.println(a.id+" : "+a.getCity()+" : "+a.getState()+" : "+a.getCountry());

        }


        transaction.commit();
        System.out.println("One to many mapping succesfully done ...");
        session.close();
       sessionFactory.close();
    }
}
