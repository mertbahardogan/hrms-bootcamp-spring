package lmonosoft.hrms.business.concretes.CheckHelper;

import lmonosoft.hrms.entities.concretes.JobAdvertisement;

public class JobAdvertisementCheckHelper {
	public static boolean isFillAllFields(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getDescription().strip().isEmpty()
				|| jobAdvertisement.getApplicationDeadline().toString().strip().isEmpty()
				|| jobAdvertisement.getReleaseDate().toString().strip().isEmpty()
				|| jobAdvertisement.getCountOfOpenPositions() == 0 || jobAdvertisement.getJobPosition().getId() == 0
				|| jobAdvertisement.getEmployer().getId() == 0
		) {
			return false;
		}
		return true;
	}
}
