package lmonosoft.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="personnels")
public class Personnel {
	
	@Id
	@Column(name="user_id",nullable = false)
	private int userId;
	
	@Column(name="first_name",nullable = false)
	private String firstName;

	@Column(name="last_name",nullable = false)
	private String lastName;

}

