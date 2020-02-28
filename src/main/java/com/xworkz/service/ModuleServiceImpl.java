package com.xworkz.service;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.dao.ModuleDAO;
import com.xworkz.dto.ModuleDTO;
import com.xworkz.entity.ModuleEntity;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleDAO moduleDAO;

	public ModuleServiceImpl() {
		System.out.println("Created \t " + this.getClass().getSimpleName());
	}

	public boolean validateAndSave(ModuleDTO moduleDTO) {
		boolean valid = false;
		try {
			System.out.println("validateAndSave invoked " + moduleDTO);

			if (Objects.nonNull(moduleDTO)) {
				System.out.println("starting validation for " + moduleDTO);
				String UserName = moduleDTO.getUserName();
				if (UserName != null && !UserName.isEmpty() && UserName.length() >= 5) {
					System.out.println("UserName is valid");
					valid = true;
				} else {
					System.out.println("UserName is invalid");
					if (UserName == null) {
						System.out.println("UserName is null");
					}
					if (UserName != null && UserName.length() < 5) {
						System.out.println("name length is less than 5");
					}
					valid = false;
				}
				String Email = moduleDTO.getEmail();
				if (Email != null && !Email.isEmpty() && Email.length() >= 5) {
					System.out.println("Email is valid");
					valid = true;
				} else {
					if (valid) {
						System.out.println("Email is invalid");
						valid = false;

					}
				}
				
				long phoneNumber = moduleDTO.getPhoneNumber();
				
				if (phoneNumber == 10) {
					
					System.out.println("phoneNumber is valid");
					valid = true;
				} else {
					if (phoneNumber != 10) {
						System.out.println("phoneNumber is invalid");
						valid = false;
					}
				}
				String Password = moduleDTO.getPassword();
		
				if (Password != null && !Password.isEmpty() && Password.length() >= 5) {
					System.out.println("Password is valid");
					valid = true;
				} else {
					if (valid) {
						System.out.println("Password is invalid");
						valid = false;
					}
				}
				
				
				String ConfirmPassword = moduleDTO.getConfirmPassword();
				if (ConfirmPassword != null && !ConfirmPassword.isEmpty() && ConfirmPassword.length() >= 5) {
					System.out.println("ConfirmPassword is valid");
					valid = true;
				} else {
					if (valid) {
						System.out.println("ConfirmPassword is invalid");
						valid = false;
					}
				}
			}
		

			if (valid) {
				System.out.println("Data is valid ,will convert  to entity");

				ModuleEntity moduleEntity = new ModuleEntity();

				BeanUtils.copyProperties(moduleDTO, moduleEntity);
				
				ModuleEntity moduleEntity1 =  moduleDAO.fetchByEmail(moduleDTO.getEmail());
				if(moduleEntity1==null) {
				System.out.println("entity is ready \t " + moduleEntity);
				//System.out.println("");
				moduleDAO.save(moduleEntity);
			}
				else {
					System.out.println("entity as saved email already exist"+moduleDTO.getEmail());
					valid=false;
				}
			}

			}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
