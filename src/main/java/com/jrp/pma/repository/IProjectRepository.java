package com.jrp.pma.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.entity.ProjectDB;

public interface IProjectRepository extends CrudRepository<ProjectDB, Long> {

	@Override
	public List<ProjectDB> findAll();
	
}
