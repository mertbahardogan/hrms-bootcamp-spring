package lmonosoft.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lmonosoft.hrms.core.strings.ErrorMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "old_employers")
@AllArgsConstructor
@NoArgsConstructor
public class OldEmployer extends User {

	@NotBlank(message = ErrorMessages.IsFillFields)
	@NotNull(message = ErrorMessages.IsFillFields)
	@Column(name = "company_name")
	private String companyName;

	@NotBlank(message = ErrorMessages.IsFillFields)
	@NotNull(message = ErrorMessages.IsFillFields)
	@Column(name = "website")
	private String website;

	@NotBlank(message = ErrorMessages.IsFillFields)
	@NotNull(message = ErrorMessages.IsFillFields)
	@Column(name = "phone_number")
	private String phoneNumber;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne()
    @JoinColumn(name="employer_case_id")
    private EmployerCase employerCase;
}
