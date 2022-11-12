package com.cruds.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.cruds.entity.Address;
import com.cruds.entity.Course;
import com.cruds.entity.Phone;
import com.cruds.entity.Student;
import com.cruds.util.HibernateUtil;

public class TestStudent {

	public static void main(String[] args) {
		//get();
		//create();
		//update();
		demoCriteria();
	}
	
	private static void demoCriteria()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Criteria cr = session.createCriteria(Student.class);
		cr.add(Restrictions.eq("name", "Anil"));
		
		List<Student> list = cr.list();
		
		for(Student s : list)
		{
			System.out.println(s);
		}
		session.close();
		HibernateUtil.shutdown();
	}

	private static void update()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.getTransaction().begin();
		Student s1 = (Student) session.load(Student.class, 6l);
		Hibernate.initialize(s1.getCourses());
		Course c3 = new Course("Spring");
		s1.getCourses().add(c3);
		session.update(s1);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.shutdown();
		
	}
	
	private static void get()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Student s1 = (Student)session.get(Student.class, 6l);
		Hibernate.initialize(s1.getPhones());
		Hibernate.initialize(s1.getCourses());
		session.close();
		
		System.out.println(s1.getName());
		System.out.println(s1.getAddress());
		System.out.println(s1.getPhones());
		System.out.println(s1.getCourses());
		
		HibernateUtil.shutdown();
		
	}
	
	private static void create()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Address addr = new Address("Tumkur");
		Student s2 = new Student("Subbu", addr);
		
		Phone p1 = new Phone("4567", "Office");
		Phone p2 = new Phone("876", "Personal");
		Set<Phone> phones = new HashSet<>();
		phones.add(p1);
		phones.add(p2);
		s2.setPhones(phones);
		
		Course c1 = new Course("Java");
		Course c2 = new Course("Hibernate");
		
		Set<Course> courses = new HashSet<>();
		courses.add(c1);
		courses.add(c2);
		
		s2.setCourses(courses);
		session.getTransaction().begin();
		session.save(s2);
		
		session.getTransaction().commit();

		session.close();
		HibernateUtil.shutdown();

	}


}
