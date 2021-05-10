package lmonosoft.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="id",nullable = false)
	private int id;
	
	@Column(name="email",nullable = false)
	private String email;
	
	@Column(name="password",nullable = false)
	private String password;
	
	@Column(name="is_email_approved",nullable = false)
	private boolean isEmailApproved;

}
