package my.portfolio.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String name;
	private String description;
	private String img;
	@Enumerated(EnumType.STRING)
	Tech tech;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Tech getTech() {
		return tech;
	}
	public void setTech(Tech tech) {
		this.tech = tech;
	}
	
	 public boolean isValid() {
	        return name != null && !name.trim().isEmpty()
	                && description != null && !description.trim().isEmpty()
	                && img != null && !img.trim().isEmpty()
	                && tech != null;
	    }
	
}
