package lmonosoft.hrms.business.concretes.CheckHelper;

import lmonosoft.hrms.entities.concretes.Employer;
import lmonosoft.hrms.entities.concretes.Personnel;

public class PersonnelCheckHelper {

	public static boolean confirmEmployer(Employer employer) {
		System.out.println(employer.getEmail() + " employer is confirmed.");
		return true;
	}

	public static boolean confirmEmployer(Personnel personnel, Employer employer) {
		System.out.println(employer.getEmail() + " employer is confirmed. By " + personnel.getFirstName());
		return true;
	}

}
