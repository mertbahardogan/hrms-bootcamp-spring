package lmonosoft.hrms.business.concretes.CheckHelper;

import com.google.common.base.Objects;

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

	public static boolean isCorrectEmail(Employer employer) {

		String[] emailArray = employer.getEmail().split("@", 2);
		String website = employer.getWebsite();
		if (website.contains("www.")) {
			website = website.substring(4);
		}
		if (emailArray[1].equals(website)) {
			return true;
		}
		return false;
	}

	public static boolean isMatchPassword(Employer employer, String passwordConfirm) {
		if (Objects.equal(passwordConfirm, employer.getPassword())) {
			return true;
		}
		return false;
	}
	// Has error for short domain and email. Temporary method.
}
