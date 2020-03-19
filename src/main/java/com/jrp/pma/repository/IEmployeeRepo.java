package com.jrp.pma.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.entity.EmployeeDB;

public interface IEmployeeRepo extends CrudRepository<EmployeeDB, Long> {
	
	public List<EmployeeDB> findAll();

}
