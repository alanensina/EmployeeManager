package com.alanensina.employeemanager.dao;

import com.alanensina.employeemanager.domain.Cargo;

import java.util.List;

public interface CargoDao {
	
	void save(Cargo cargo);

	void update(Cargo cargo);

	void delete(Long id);

	Cargo findById(Long id);

	List<Cargo> findAll();
}
