package lmonosoft.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="job_seekers")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker {
	
	@Id
	@Column(name="user_id",nullable = false)
	private int userId;
	
	@Column(name="first_name",nullable = false)
	private String firstName;
	
	@Column(name="last_name",nullable = false)
	private String lastName;
	
	@Column(name="national_id",nullable = false,unique = true)
	private String nationalId;
	
	@Column(name="birth_of_date",nullable = false)
	private LocalDate birthOfDate;
	
	@Column(name="is_mernis_approved",nullable = false)
	private boolean isMernisApproved;
	
}
