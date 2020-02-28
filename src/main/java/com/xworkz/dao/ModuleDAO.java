package com.xworkz.dao;

import java.io.Serializable;

import com.xworkz.entity.ModuleEntity;

public interface ModuleDAO {
	public void save(ModuleEntity moduleEntity);
	public ModuleEntity fetchByEmail(String email);
}
