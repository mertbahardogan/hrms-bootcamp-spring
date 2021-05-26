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

	public static boolean isSameDomains(Employer employer) {
		var employerWebsiteLength = employer.getWebsite().length();
		if (employer.getEmail()
				.contains(employer.getWebsite().substring(employerWebsiteLength - 8, employerWebsiteLength - 4))) {
			return true;
		}
		return false;
	}
	//Has error for short domain and email. Temporary method.
}
