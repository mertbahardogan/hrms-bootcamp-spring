package lmonosoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import lmonosoft.hrms.business.abstracts.EmailService;
import lmonosoft.hrms.business.abstracts.EmployerService;
import lmonosoft.hrms.business.concretes.CheckHelper.EmployerCheckHelper;
import lmonosoft.hrms.business.concretes.CheckHelper.PersonnelCheckHelper;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.ErrorResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.core.utilities.results.SuccessDataResult;
import lmonosoft.hrms.core.utilities.results.SuccessResult;
import lmonosoft.hrms.dataAccess.abstracts.EmployerDao;
import lmonosoft.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailService emailService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailService emailService) {
		super();
		this.employerDao = employerDao;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employers listed.");
	}

	@Override
	public Result register(Employer employer, String passwordConfirm) {
		var checkFields = !EmployerCheckHelper.isFillAllFields(employer);
		var checkEmail = employerDao.findByEmail(employer.getEmail()).size() != 0;
		var checkPassword = !Objects.equal(passwordConfirm, employer.getPassword());
		var checkPersonelConfirm = !PersonnelCheckHelper.confirmEmployer(employer);
		var checkDommain = !EmployerCheckHelper.isSameDomains(employer);

		if (checkEmail || checkFields || checkPassword || checkPersonelConfirm || checkDommain) {
			String errorMessage = "";

			if (checkEmail) {
				errorMessage = "Email name already exist.";
			}
			if (checkPassword) {
				errorMessage = "Passwords is not equal each other.";
			}
			if (checkPersonelConfirm) {
				errorMessage = "Personnel of HRMS not confirm your register.";
			}
			if (checkFields) {
				errorMessage = "All fields are not filled.";
			}
			if (checkDommain) {
				errorMessage = "Email and website domain not equal.";
			}
			return new ErrorResult(errorMessage);
		}

		employerDao.save(employer);
		return new SuccessResult("Employer added and " + emailService.sendEmail(employer).getMessage());
	}

}
