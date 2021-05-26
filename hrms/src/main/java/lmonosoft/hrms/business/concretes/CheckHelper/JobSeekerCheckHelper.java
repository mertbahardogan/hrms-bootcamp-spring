package lmonosoft.hrms.business.concretes.CheckHelper;

import lmonosoft.hrms.entities.concretes.JobSeeker;

public class JobSeekerCheckHelper {

	public static boolean isFillAllFields(JobSeeker jobSeeker, String passwordConfirm) {

		if (jobSeeker.getEmail().strip().isEmpty() || jobSeeker.getPassword().strip().isEmpty()
				|| jobSeeker.getFirstName().strip().isEmpty() || jobSeeker.getLastName().strip().isEmpty()
				|| jobSeeker.getNationalId().strip().isEmpty()
				|| jobSeeker.getBirthOfDate().toString().strip().isEmpty() || passwordConfirm.strip().isEmpty()) {

			return false;
		}
		return true;

	};

}
