package com.xworkz.dao;

import com.xworkz.entity.ModuleEntity;

public interface LoginDAO {
	public ModuleEntity fetchByEmailAndPassword(String password, String email);
}

