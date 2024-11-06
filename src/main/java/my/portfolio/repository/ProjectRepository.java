package my.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.portfolio.model.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{
	
	
	

}
