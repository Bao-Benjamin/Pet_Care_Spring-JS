package training.javaweb.exam.JavaWebExam_lhgbao.entities;

import jakarta.validation.constraints.NotEmpty;
import training.javaweb.exam.JavaWebExam_lhgbao.enums.status.BoardingStatus;
import training.javaweb.exam.JavaWebExam_lhgbao.enums.types.Types;

public class Pet {
	private Integer id;
	private String name;
	private Double age;
	private Integer ownerId;
	private Types type;
	private double weight;
	private String species;
	private BoardingStatus status;
	private String image;
	public Pet() {
		super();
	}
	public Pet(Integer id, String name, Double age, Integer ownerId, Types type, double weight, String species,
			BoardingStatus status, String image) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.ownerId = ownerId;
		this.type = type;
		this.weight = weight;
		this.species = species;
		this.status = status;
		this.image = image;
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
	public Double getAge() {
		return age;
	}
	public void setAge(Double age) {
		this.age = age;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public Types getType() {
		return type;
	}
	public void setType(Types type) {
		this.type = type;
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public BoardingStatus getStatus() {
		return status;
	}

	public void setStatus(BoardingStatus status) {
		this.status = status;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", age=" + age + ", ownerId=" + ownerId + ", type=" + type
				+ ", weight=" + weight + ", species=" + species + ", status=" + status + "]";
	}

	
	
}
