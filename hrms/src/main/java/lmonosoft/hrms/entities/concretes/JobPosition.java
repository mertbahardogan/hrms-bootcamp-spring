package lmonosoft.hrms.entities.concretes;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="job_positions")
@Data
public class JobPosition {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable = false)
	private int id;
	
	@Column(name="employer_id",nullable = false)
	private int employerId;
	
	@Column(name="name",nullable = false,unique = true)
	private String name;
	
	
	
	

}
