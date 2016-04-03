package com.utils.samples.hibernate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.utils.samples.hibernate.model.FourWheeler;
import com.utils.samples.hibernate.model.Student;
import com.utils.samples.hibernate.model.TwoWheeler;
import com.utils.samples.hibernate.model.University;
import com.utils.samples.hibernate.model.UserDetails;
import com.utils.samples.hibernate.model.Vehicle;

@Transactional
public class HibernateTest {
	
	private static final Logger LOG=Logger.getLogger(HibernateTest.class);
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory==null){
			
		    Configuration configuration = new Configuration();
		    configuration.configure();
		    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		    return sessionFactory;
		}
		return sessionFactory;

	}
	
	@SuppressWarnings("unchecked")
	@Test
	public  void TestManyToOne() {
		Student student1 = new Student("Sam","Disilva","Maths");
        Student student2 = new Student("Joshua", "Brill", "Science");
        Student student3 = new Student("Peter", "Pan", "Physics");
         
        University university = new University("CAMBRIDGE", "ENGLAND");
 
        student1.setUniversity(university);
        student2.setUniversity(university);
        student3.setUniversity(university);
 
 
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
 
        session.persist(university);
        session.persist(student1);
        session.persist(student2);
        session.persist(student3);
         
        List<Student> students = (List<Student>)session.createQuery("from Student ").list();
        assertThat(3, is(students.size()));
        assertThat(university, is(students.get(0).getUniversity()));
        
        for(Student s: students){
            LOG.info("Details : "+s);
            LOG.info("Student University Details: "+s.getUniversity());
        }
         
        session.getTransaction().commit();
        session.close();  
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public  void testBasicMappings() {
		SessionFactory sessionFactory=getSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		
		Query query=session.createQuery("from UserDetails");
		//Query query=session.createQuery("select userName from UserDetails");
		List<UserDetails> users=(List<UserDetails>)query.list();
		//List<String> users=(List<String>)query.list();
		assertThat(0, is(users.size()));
		
		UserDetails user = new UserDetails();
		user.setDescription("New user");
		user.setJoinedDate(new Date());
		user.setUserName("Selman");
		
		session.save(user);
		
		users=(List<UserDetails>)query.list();
		assertThat(1, is(users.size()));
		
		user = (UserDetails) session.get(UserDetails.class, 1);
		user.setUserName("updated user");
		session.update(user);
		
		users=(List<UserDetails>)query.list();
		assertThat("updated user", is(users.get(0).getUserName()));

		Vehicle vehicle =new Vehicle();
		vehicle.setVehicleName("araba");
		
		TwoWheeler bike=new TwoWheeler();
		bike.setVehicleName("bike");
		bike.setSteeringHandle("bike steering handler");
		
		FourWheeler car=new FourWheeler();
		bike.setVehicleName("car");
		bike.setSteeringHandle("car steering wheel");

		session.save(vehicle);
		session.save(bike);
		session.save(car);
		
		Query queryVehicle=session.createQuery("from Vehicle");
		List<Vehicle> vehicles=(List<Vehicle>)queryVehicle.list();
		Vehicle vehicleManaged = vehicles.get(0);
		assertThat("araba", is(vehicleManaged.getVehicleName()));
		
		session.getTransaction().commit();
		session.close();

	}

}
