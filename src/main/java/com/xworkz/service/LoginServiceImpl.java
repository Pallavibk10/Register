package com.xworkz.service;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.dao.LoginDAO;
import com.xworkz.dto.LoginDTO;
import com.xworkz.entity.ModuleEntity;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginDAO dao;
	
	public LoginServiceImpl() {
		System.out.println("Created\t"+this.getClass().getSimpleName());
	}
	

	public boolean validateLogin(LoginDTO dto) {

		boolean valid = false;
		try {
			System.out.println("dataSave invoked " + dto);

			if (Objects.nonNull(dto)) {

				ModuleEntity modl=new ModuleEntity();
				BeanUtils.copyProperties(dto, modl);
				ModuleEntity modl1=dao.fetchByEmailAndPassword(dto.getEmail(), dto.getPassword());

				if (modl1 !=null) {
					System.out.println("entity is ready \t " + modl);
					dao.fetchByEmailAndPassword(dto.getEmail(), dto.getPassword());
					System.out.println("Email is exist");
					return true;
				}
				} else {
					System.out.println("entity as saved email already exits");
					return false;
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;

	}


	
}


