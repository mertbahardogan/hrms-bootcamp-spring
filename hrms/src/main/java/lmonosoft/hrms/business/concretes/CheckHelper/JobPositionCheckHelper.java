package lmonosoft.hrms.business.concretes.CheckHelper;

import lmonosoft.hrms.entities.concretes.JobPosition;

public class JobPositionCheckHelper {

	public static boolean isFillAllFields(JobPosition jobPosition) {
		if (jobPosition.getName().strip().isEmpty() || jobPosition.getEmployerId() == 0) {
			return false;
		}
		return true;
	}

}
