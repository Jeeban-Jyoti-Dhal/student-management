package in.ashokit.entity;

import java.io.Serializable;

import lombok.Data;
@Data
public class Student implements Serializable {
	
	private Integer id;
	private String name;
	private Long mobile;
	private String country;
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobile=" + mobile + ", country=" + country + "]";
	}
	

}
