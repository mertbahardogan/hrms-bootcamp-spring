package lmonosoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import lmonosoft.hrms.business.abstracts.EmailService;
import lmonosoft.hrms.business.abstracts.JobSeekerService;
import lmonosoft.hrms.business.concretes.CheckHelper.JobSeekerCheckHelper;
import lmonosoft.hrms.core.adapters.abstracts.UserCheckService;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.ErrorResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.core.utilities.results.SuccessDataResult;
import lmonosoft.hrms.core.utilities.results.SuccessResult;
import lmonosoft.hrms.dataAccess.abstracts.JobSeekerDao;
import lmonosoft.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private UserCheckService userCheckService;
	private EmailService emailService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserCheckService userCheckService, EmailService emailService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userCheckService = userCheckService;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Job Seekers listed.");
	}

	@Override
	public Result register(JobSeeker jobSeeker, String passwordConfirm) {
		var isRealPerson = !this.userCheckService.isRealPerson(jobSeeker.getFirstName(), jobSeeker.getLastName(),
				jobSeeker.getNationalId(), jobSeeker.getBirthOfDate());
		var checkEmail = this.jobSeekerDao.findByEmail(jobSeeker.getEmail()).size() != 0;
		var checkNationalId = this.jobSeekerDao.findByNationalId(jobSeeker.getNationalId()).size() != 0;
		var checkFields = !JobSeekerCheckHelper.isFillAllFields(jobSeeker, passwordConfirm);
		var checkPassword = !Objects.equal(passwordConfirm, jobSeeker.getPassword());

		System.out.println(!Objects.equal(passwordConfirm, jobSeeker.getPassword()));
		System.out.println(jobSeeker.getPassword() + " " + passwordConfirm);

		if (isRealPerson || checkFields || checkEmail || checkNationalId || checkPassword) {
			String errorMessage = "";

			if (isRealPerson) {
				errorMessage = "Mernis. Person is not real.";
			}
			if (checkEmail || checkNationalId) {
				errorMessage = "This email or national id already exists.";
			}

			if (checkPassword) {
				errorMessage = "Passwords is not equal each other.";
			}
			if (checkFields) {
				errorMessage = "All fields are not filled.";
			}
			return new ErrorResult("Job Seeker Error: " + errorMessage);
		}
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Job Seeker added and " + emailService.sendEmail(jobSeeker).getMessage());
	}

}
