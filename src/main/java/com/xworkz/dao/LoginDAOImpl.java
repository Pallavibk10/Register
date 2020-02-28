package com.xworkz.dao;

import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.entity.ModuleEntity;
@Component
public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	private SessionFactory factroy;
	
	public LoginDAOImpl() {
		System.out.println("Created\t"+this.getClass().getSimpleName());
	}
	public ModuleEntity fetchByEmailAndPassword(String password, String email) {
		Session session=null;
		
		try {
			session = factroy.openSession();
			System.out.println("invoke fetchByEmailAndPassword()...");
			Query query=session.getNamedQuery("fetchByEmailAndPassword");
			
			query.setParameter("email", email);
			query.setParameter("password", password);
			Object result=query.uniqueResult();
			if(Objects.nonNull(result))
			{
				System.out.println("Entity found"+"\t"+password+"\t"+email);
				ModuleEntity entity =(ModuleEntity) result;
				return entity;
			}
			else
			{
				System.out.println("Entity not found");
				return null;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			if(Objects.nonNull(session))
				session.close();
		}
		return null;
	}

}
