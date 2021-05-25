package lmonosoft.hrms.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name="user_id")
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "personnels")
@AllArgsConstructor
@NoArgsConstructor
public class Personnel extends User { // extends User

	//@Id
	//@Column(name = "user_id")
	//private int userId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

}
