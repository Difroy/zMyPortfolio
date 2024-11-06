package my.portfolio.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Project> getProjectById(@PathVariable int id) {
	        Optional<Project> project = projectRepository.findById(id);
	        if (project.isPresent()) {
	            return ResponseEntity.ok(project.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
	 @PostMapping
	    public ResponseEntity<Project> createProject(@RequestBody Project pro) {
	        if (pro.isValid()) {
	            Project savedProject = projectRepository.save(pro);
	            return ResponseEntity.status(HttpStatus.CREATED).body(savedProject);
	        } else {
	            return ResponseEntity.badRequest().build();
	        }
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Project> updateProject(@PathVariable int id, @RequestBody Project updatedProject) {
	        Optional<Project> existingProject = projectRepository.findById(id);
	        if (existingProject.isPresent()) {
	            Project project = existingProject.get();
	            project.setName(updatedProject.getName());
	            project.setDescription(updatedProject.getDescription());
	            project.setImg(updatedProject.getImg());
	            project.setTech(updatedProject.getTech());

	            Project savedProject = projectRepository.save(project);
	            return ResponseEntity.ok(savedProject);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProject(@PathVariable int id) {
	        if (projectRepository.existsById(id)) {
	            projectRepository.deleteById(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	
	 }
	
}
