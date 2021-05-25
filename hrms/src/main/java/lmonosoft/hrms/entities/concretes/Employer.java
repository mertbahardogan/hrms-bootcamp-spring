package lmonosoft.hrms.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User {

	// @Id
	// @Column(name = "user_id")
	// private int userId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "website")
	private String website;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "is_admin_approved")
	private boolean isAdminApproved;

}
