package lmonosoft.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lmonosoft.hrms.core.strings.ErrorMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotBlank(message = ErrorMessages.IsFillFields)
	@NotNull(message = ErrorMessages.IsFillFields)
	@Column(name = "description")
	private String description;

	// fix that
	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "count_of_open_positions")
	private int countOfOpenPositions;

	// if jobSeeker run, add that row in here
	@Column(name = "application_deadline")
	private LocalDate applicationDeadline;

	@JsonIgnore
	@Column(name = "release_date")
	private LocalDate releaseDate = LocalDate.now();

	@Column(name = "minimum_salary")
	private int minimumSalary;

	@Column(name = "maximum_salary")
	private int maximumSalary;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
}
