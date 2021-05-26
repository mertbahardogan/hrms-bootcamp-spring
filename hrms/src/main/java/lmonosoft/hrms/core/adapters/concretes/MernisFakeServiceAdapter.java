package lmonosoft.hrms.core.adapters.concretes;

import java.time.LocalDate;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lmonosoft.hrms.MernisFakeService;
import lmonosoft.hrms.core.adapters.abstracts.UserCheckService;

@Component
//@Primary
public class MernisFakeServiceAdapter implements UserCheckService {

	@Override
	public boolean isRealPerson(String firstName, String lastName, String nationalId, LocalDate birthOfDate) {
		boolean result = false;
		MernisFakeService mernisService = new MernisFakeService();
		result = mernisService.userValidationWithMernis(firstName, lastName, nationalId, birthOfDate);
		return result;
	}

}
