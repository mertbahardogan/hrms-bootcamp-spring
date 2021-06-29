package lmonosoft.hrms.entities.concretes;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lmonosoft.hrms.core.strings.ErrorMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvertisements" })
public class Employer extends User {

//	@Id
//	@Column(name = "user_id")
//	@PrimaryKeyJoinColumn
//	private int userId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "phone_number")
	private String phoneNumber;

	@ManyToOne()
	@JoinColumn(name = "employer_case_id")
	private EmployerCase employerCase;

	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<OldEmployer> oldEmployers;

	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;

	@NotBlank(message = ErrorMessages.IsFillFields)
	@NotNull(message = ErrorMessages.IsFillFields)
	@Column(name = "website")
	private String website;
}
