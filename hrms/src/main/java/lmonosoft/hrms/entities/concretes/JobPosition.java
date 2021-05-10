package lmonosoft.hrms.entities.concretes;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="job_positions")
@Data
public class JobPosition {
	
	@Id 
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="employer_id")
	private int employer_id;
	
	@Column(name="name")
	private String name;
	
	
	
	

}
