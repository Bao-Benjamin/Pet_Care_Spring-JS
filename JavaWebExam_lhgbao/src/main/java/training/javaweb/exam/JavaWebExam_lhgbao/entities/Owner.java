package training.javaweb.exam.JavaWebExam_lhgbao.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import training.javaweb.exam.JavaWebExam_lhgbao.enums.roles.Roles;

public class Owner {
	private Integer id;
	@NotEmpty(message= "owner name can not empty")
	private String name;
	@NotEmpty(message="phone can not empty")
	private String phoneNumber;
	private String email;
	private String address;
	private Boolean hadAccount;
	public Owner() {
		super();
	}

	public Owner(Integer id, @NotEmpty(message = "owner name can not empty") String name,
			@NotEmpty(message = "phone can not empty") String phoneNumber, String email, String address,
			Boolean hadAccount) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.hadAccount = hadAccount;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public Boolean getHadAccount() {
		return hadAccount;
	}

	public void setHadAccount(Boolean hadAccount) {
		this.hadAccount = hadAccount;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address="
				+ address + ", hadAccount=" + hadAccount + "]";
	}

}
