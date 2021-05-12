package lmonosoft.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="employers")
public class Employer {
	
	@Id
	@Column(name="user_id",nullable = false)
	private int userId;
	
	@Column(name="company_name",nullable = false)
	private String companyName;
	
	@Column(name="website",nullable = false)
	private String website;
	
	@Column(name="phone_number",nullable = false)
	private String phoneNumber;
	
	@Column(name="is_admin_approved",nullable = false)
	private boolean isAdminApproved;

}
