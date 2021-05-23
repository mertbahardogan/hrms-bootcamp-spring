package lmonosoft.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="personnels")
@AllArgsConstructor
@NoArgsConstructor
public class Personnel {
	
	@Id
	@Column(name="user_id",nullable = false)
	private int userId;
	
	@Column(name="first_name",nullable = false)
	private String firstName;

	@Column(name="last_name",nullable = false)
	private String lastName;

}

