package lmonosoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import lmonosoft.hrms.business.abstracts.EmailService;
import lmonosoft.hrms.business.abstracts.EmployerService;
import lmonosoft.hrms.business.abstracts.OldEmployerService;
import lmonosoft.hrms.business.concretes.CheckHelper.EmployerCheckHelper;
import lmonosoft.hrms.business.concretes.CheckHelper.PersonnelCheckHelper;
import lmonosoft.hrms.core.strings.ErrorMessages;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.ErrorResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.core.utilities.results.SuccessDataResult;
import lmonosoft.hrms.core.utilities.results.SuccessResult;
import lmonosoft.hrms.dataAccess.abstracts.EmployerDao;
import lmonosoft.hrms.dataAccess.abstracts.OldEmployerDao;
import lmonosoft.hrms.entities.concretes.Employer;
import lmonosoft.hrms.entities.concretes.EmployerCase;
import lmonosoft.hrms.entities.concretes.OldEmployer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailService emailService;
	private OldEmployerService oldEmployerService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailService emailService, OldEmployerService oldEmployerService) {
		super();
		this.employerDao = employerDao;
		this.emailService = emailService;
		this.oldEmployerService = oldEmployerService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public Result register(Employer employer, String passwordConfirm) {
		var checkFields = !EmployerCheckHelper.isFillAllFields(employer);
		var checkEmail = employerDao.findByEmail(employer.getEmail()).size() != 0;
		var checkPassword = !EmployerCheckHelper.isMatchPassword(employer, passwordConfirm);
		var checkPersonelConfirm = !PersonnelCheckHelper.confirmEmployer(employer);
		var checkDommain = !EmployerCheckHelper.isCorrectEmail(employer);

		if (checkEmail || checkFields || checkPassword || checkPersonelConfirm || checkDommain) {
			String errorMessage = "";

			if (checkEmail) {
				errorMessage = ErrorMessages.IsExistEmail;
			}
			if (checkPassword) {
				errorMessage = ErrorMessages.IsMatchPasswords;
			}
			if (checkPersonelConfirm) {
				errorMessage = ErrorMessages.IsConfirmPersonnel;
			}
			if (checkFields) {
				errorMessage = ErrorMessages.IsFillFields;
			}
			if (checkDommain) {
				errorMessage = ErrorMessages.IsMatchDomain;
			}
			return new ErrorResult(errorMessage);
		}
		employerDao.save(employer);
		return new SuccessResult("Employer added and " + emailService.sendEmail(employer).getMessage());
	}

	@Override
	public DataResult<List<Employer>> getEmployerById(int id) {
		var value = employerDao.getEmployerById(id).get(0);
//		return new SuccessDataResult<List<Employer>>(employerDao.getEmployerById(id));
		if (value.getEmployerCase().getId() == 1) {
			return new SuccessDataResult(employerDao.getEmployerById(id), "Onaylandı");
		} else if (value.getEmployerCase().getId() == 2) {
			return new SuccessDataResult(oldEmployerService.getbyEmployerid(id), "Onay Bekliyor");
		} else {
			return new SuccessDataResult(oldEmployerService.getbyEmployerid(id), "Reddedildi");
		}
	}

	@Override
	public Result update(int id, Employer employer) {
		var value = employerDao.getEmployerById(id).get(0);

		var oldValue = new OldEmployer();
		oldValue.setCompanyName(value.getCompanyName());
		oldValue.setEmail(value.getEmail());
		oldValue.setPassword(value.getPassword());
		oldValue.setPhoneNumber(value.getPhoneNumber());
		oldValue.setWebsite(value.getWebsite());
		oldValue.setEmployer(value);

		if (this.oldEmployerService.getbyEmployerid(id) == null) {
			this.oldEmployerService.add(oldValue);
		} else {
			var valueForUpdate = this.oldEmployerService.getbyEmployerid(id);
			valueForUpdate.setCompanyName(oldValue.getCompanyName());
			valueForUpdate.setEmail(oldValue.getEmail());
			valueForUpdate.setPassword(oldValue.getPassword());
			valueForUpdate.setPhoneNumber(oldValue.getPhoneNumber());
			valueForUpdate.setWebsite(oldValue.getWebsite());
			valueForUpdate.setEmployerCase(employer.getEmployerCase());
			valueForUpdate.setEmployer(value);
		}
		value.setCompanyName(employer.getCompanyName());
		value.setEmail(employer.getEmail());
		value.setPassword(employer.getPassword());
		value.setPhoneNumber(employer.getPhoneNumber());
		value.setWebsite(employer.getWebsite());
		value.setEmployerCase(employer.getEmployerCase());
		employerDao.save(value);
		return new SuccessResult();
	}

	@Override
	public Result ConfirmUpdate(EmployerCase employerCase, int EmployerId) {
		var value = employerDao.getEmployerById(EmployerId).get(0);
		value.setEmployerCase(employerCase);
		employerDao.save(value);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Employer>> getByIdForUsers(int id) {
		var value = employerDao.getEmployerById(id).get(0);
		if (value.getEmployerCase().getId() == 1) {
			return new SuccessDataResult<List<Employer>>(this.employerDao.getEmployerById(id));
		} else if (value.getEmployerCase().getId() == 2) {
			return new SuccessDataResult(oldEmployerService.getbyEmployerid(id),
					(value.getEmployerCase().getCaseName()));
		} else {
			return new SuccessDataResult(oldEmployerService.getbyEmployerid(id),
					(value.getEmployerCase().getCaseName()).toString());
		}

	}

	@Override
	public DataResult<List<Employer>> getByIdForAdmins(int id) {
		return new SuccessDataResult<List<Employer>>(this.employerDao.getEmployerById(id));
	}

	@Override
	public DataResult<List<Employer>> getByEmployerCase_id() {
		return new SuccessDataResult<List<Employer>>(employerDao.getByEmployerCase_id(2));
	}

}
