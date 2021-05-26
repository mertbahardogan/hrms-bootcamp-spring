package lmonosoft.hrms.business.concretes.CheckHelper;

import lmonosoft.hrms.entities.concretes.Employer;

public class EmployerCheckHelper {

	public static boolean isFillAllFields(Employer employer) {
		if (employer.getCompanyName().strip().isEmpty() || employer.getWebsite().strip().isEmpty()
				|| employer.getEmail().strip().isEmpty() || employer.getPhoneNumber().strip().isEmpty()
				|| employer.getPassword().strip().isEmpty()) {
			return false;
		}
		return true;
	}
}
