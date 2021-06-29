package lmonosoft.hrms.business.abstracts;

import org.springframework.stereotype.Service;

import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.entities.concretes.User;

@Service
public interface EmailService {
	Result sendEmail(User user);


}
