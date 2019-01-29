package natan.io.projeto1.entity;

import java.util.Set;

import javax.persistence.*;

import org.springframework.data.mongodb.core.mapping.Document;


// Para não desfazer o User do MYSQL, criei outro user para o MongoDB

@Document
public class UserMongo {

	@Id
	private String id;
	private String name;
	private String email;

	private Set<Role> roles;

	public UserMongo() {
	}

	public UserMongo(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
