package lmonosoft.hrms.entities.concretes;

import javax.persistence.*;
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
@Table(name = "personnels")
@AllArgsConstructor
@NoArgsConstructor
public class Personnel extends User {

	@NotBlank(message = ErrorMessages.IsFillFields)
	@NotNull(message = ErrorMessages.IsFillFields)
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = ErrorMessages.IsFillFields)
	@NotNull(message = ErrorMessages.IsFillFields)
	@Column(name = "last_name")
	private String lastName;

}
