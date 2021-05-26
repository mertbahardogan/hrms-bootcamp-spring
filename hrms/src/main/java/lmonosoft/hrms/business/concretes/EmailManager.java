package lmonosoft.hrms.business.concretes;

import org.springframework.stereotype.Component;

import lmonosoft.hrms.business.abstracts.EmailService;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.core.utilities.results.SuccessResult;
import lmonosoft.hrms.entities.concretes.User;

@Component
public class EmailManager implements EmailService {

	@Override
	public Result sendEmail(User user) {
		return new SuccessResult("Email sent to " + user.getEmail() + ". Enter verification code.");
	}

}
