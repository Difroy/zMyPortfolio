package my.portfolio.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.portfolio.model.entities.Project;
import my.portfolio.repository.ProjectRepository;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
@RequestMapping ("api/project")
public class ProjectController {

	@Autowired
	ProjectRepository projectRepository;
	
	
	 @GetMapping
	    public ResponseEntity<List<Project>> getAllProjects() {
	        List<Project> projects = projectRepository.findAll();
	        return ResponseEntity.ok(projects);
	    }
	
	 
	
	
	
	
}
