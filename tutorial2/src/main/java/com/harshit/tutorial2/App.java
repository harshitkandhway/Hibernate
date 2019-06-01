package com.harshit.tutorial2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public void databaseRelationsInHibernate()
	{
		Laptop l1 = new Laptop();
        l1.setLaptopId(101);
        l1.setLaptopManufacturer("Dell");
        l1.setLaptopName("Inspiron");
        
        Laptop l2 =new Laptop();
        l2.setLaptopId(102);
        l2.setLaptopManufacturer("HP");
        l2.setLaptopName("Pavilion");
        
        Laptop l3 = new Laptop();
        l3.setLaptopId(103);
        l3.setLaptopManufacturer("Apple");
        l3.setLaptopName("ipad");
        
        Student s1 = new Student();
        s1.setStudentId(1);
        s1.setStudentName("Harshit");
        List<Laptop> llist1 = new ArrayList<Laptop>();
        llist1.add(l1);
        llist1.add(l2);
        s1.setLaptoplist(llist1);
        
        Student s2 = new Student();
        s2.setStudentId(2);
        s2.setStudentName("Vishal");
        List<Laptop> llist2 = new ArrayList<Laptop>();
        llist2.add(l3);
        llist2.add(l1);
        s2.setLaptoplist(llist2);
        
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        
        Transaction tx = s.beginTransaction();
        Student stud = s.get(Student.class, 1);
        System.out.println(stud.getStudentName());
        /**
        List<Laptop> laplist = stud.getLaptoplist();
        for(Laptop laptop :laplist)
        {
        	System.out.println(laptop.getLaptopId());
        }
     **/
        //System.out.println(stud.getLaptoplist());
        /**
        s.save(s1);
        s.save(s2);
        s.save(l1);
        s.save(l2);
        s.save(l3);
        **/
        
        tx.commit();
        
     
	}
	
	public void workingWithFetchType() {
		
		/**
		 * Adding values in database
		Department d1 = new Department();
		d1.setDeptId(100);
		d1.setDeptName("Professional Services");
		
		Department d2 = new Department();
		d2.setDeptId(200);
		d2.setDeptName("Research and Development");
		
		Employee e1 = new Employee();
		e1.setEmpId(1);
		e1.setEmpName("Harshit");
		e1.setEmpDept(d1);
		
		Employee e2 = new Employee();
		e2.setEmpId(2);
		e2.setEmpDept(d1);
		e2.setEmpName("Aritro");
		
		Employee e3 = new Employee();
		e3.setEmpId(3);
		e3.setEmpName("Biswajit");
		e3.setEmpDept(d1);
		
		Employee e4 = new Employee();
		e4.setEmpDept(d2);
		e4.setEmpId(4);
		e4.setEmpName("Mousumi");
		
		Employee e5 = new Employee();
		e5.setEmpDept(d2);
		e5.setEmpId(5);
		e5.setEmpName("Rohit");
		**/
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        
        Department deptvar = s.get(Department.class, 100);
        System.out.println(deptvar.getDeptName());
        
        /**
        Collection<Employee> emplist = deptvar.getEmplist();
        for(Employee e : emplist)
        {
        	System.out.println(e.getEmpName());
        }
        //Employee emp = s.get(Employee.class,1);
        //System.out.println(emp.getEmpName());
         **/
        
        /**
        s.save(d1); 
        s.save(d2);
        s.save(e1);
        s.save(e2);
        s.save(e3);
        s.save(e4);
        s.save(e5);
        **/
        tx.commit();
	}
	
	public void cachingLevel1() {
		
		User u1 =new User(1,"Harshit");
		User u2 =new User(2,"Anudeep");
		User u3 = new User(3,"Rohan");
		//Knowing Employee table has data;
		Configuration cfg = new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		User u = (User)session.get(User.class,1);
		System.out.println(u.getUname());
		t.commit();
		session.close();
		
		Session session2 = sf.openSession();
		Transaction t2 = session2.beginTransaction();
		User user2 = (User)session2.get(User.class,1);
		System.out.println(user2.getUname());
		t2.commit();
		session2.close();
		
	}
	
    public static void main( String[] args )
    {
    	App app = new App();
    	//app.workingWithFetchType();
    	app.cachingLevel1();
    	
    	
        
    }
}
