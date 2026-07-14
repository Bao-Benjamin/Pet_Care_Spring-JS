package training.javaweb.exam.JavaWebExam_lhgbao.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import training.javaweb.exam.JavaWebExam_lhgbao.enums.roles.Roles;

public class Account {
	private Integer id;
	@NotBlank(message="password is required")
	private String password;
	private Integer ownerId;
	private Roles roles;
	public Account() {
		super();
	}
	
	public Account(Integer id, @NotBlank(message = "password is required") String password, Integer ownerId,
			Roles roles) {
		super();
		this.id = id;
		this.password = password;
		this.ownerId = ownerId;
		this.roles = roles;
	}
	public Account(@NotBlank(message = "password is required") String password, Integer ownerId) {
		super();
		this.password = password;
		this.ownerId = ownerId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	

	
	
}
