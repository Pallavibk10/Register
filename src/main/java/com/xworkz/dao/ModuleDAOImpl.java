package com.xworkz.dao;



import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.entity.ModuleEntity;

@Repository
public class ModuleDAOImpl implements ModuleDAO {
	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	public ModuleDAOImpl() {
		System.out.println("Created \t "+this.getClass().getSimpleName());
	}

	public void save(ModuleEntity moduleEntity) {
		System.out.println("Invoking save method");
		Session session = null;
		try {

			System.out.println("session created");
			session = factory.openSession();
			System.out.println("Transaction begin");
			session.beginTransaction();
			System.out.println("Entity saving...");
			session.save(moduleEntity);
			System.out.println("Commiting....");
			session.getTransaction().commit();
			System.out.println("Data saved");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("INFO:" + e.getMessage());
		}
		
		
	}

	public ModuleEntity fetchByEmail(String email) {
		Session session=factory.openSession();
		try {
			String syntax="SELECT SE from ModuleEntity SE where SE.email='"+email+"'";
			Query query = session.createQuery(syntax);
			Object result = query.uniqueResult();
			if(result!=null)
			return(ModuleEntity) result;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			 {
				session.close();
			}
		}
		return null;
	}

	
	
}

