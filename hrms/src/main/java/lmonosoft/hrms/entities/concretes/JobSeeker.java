package lmonosoft.hrms.entities.concretes;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

import lmonosoft.hrms.core.strings.ErrorMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@Table(name = "job_seekers")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User {

	@NotBlank(message = ErrorMessages.IsFillFields)
	@NotNull(message = ErrorMessages.IsFillFields)
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = ErrorMessages.IsFillFields)
	@NotNull(message = ErrorMessages.IsFillFields)
	@Column(name = "last_name")
	private String lastName;

	@Size(min = 11, message = "National Id must be 11 characters.")
	@NotBlank(message = ErrorMessages.IsFillFields)
	@NotNull(message = ErrorMessages.IsFillFields)
	@Column(name = "national_id")
	private String nationalId;

	@NotNull(message = ErrorMessages.IsFillFields) // sorun olabilir
	@Column(name = "birth_of_date")
	private LocalDate birthOfDate;

	@Column(name = "cover_letter")
	private String coverLetter;

	// @JsonIgnore()
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerExperience> jobSeekerExperiences;

	// @JsonIgnore()
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerLanguage> jobSeekerLanguages;

	// @JsonIgnore()
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerLink> jobSeekerLinks;

	// @JsonIgnore()
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerEducation> jobSeekerEducations;
}
