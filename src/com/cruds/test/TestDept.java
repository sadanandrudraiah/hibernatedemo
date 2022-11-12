package com.cruds.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cruds.entity.Department;
import com.cruds.util.HibernateUtil;

public class TestDept {

	public static void main(String[] args) {
		
		//create();
		//list();
		//update();
		//delete();
		get();
	}
	
	private static void get()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Department d = (Department) session.load(Department.class, 222);
		System.out.println(d);

		session.close();
		HibernateUtil.shutdown();
	}
	
	private static void delete()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.getTransaction().begin();
		Department d = (Department) session.load(Department.class, 101);
		
		session.delete(d);
		session.getTransaction().commit();
		
		session.close();
		HibernateUtil.shutdown();
		
	}	
	
	private static void update()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.getTransaction().begin();
		Department d = (Department) session.load(Department.class, 101);
		d.setDeptName("Human Resource");
		
		session.update(d);
		session.getTransaction().commit();
		
		session.close();
		HibernateUtil.shutdown();
		
	}
	
	private static void list()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		List<Department> list = (List<Department>) session.createQuery("from Department").list();
		
		for(Department d : list)
		{
			System.out.println(d);
		}
		session.close();
		HibernateUtil.shutdown();

	}
	
	
	private static void create()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		Department d = new Department(222,"PROD");
		session.save(d);
		tx.commit();
		session.close();
		HibernateUtil.shutdown();
		
	}

}
