package lmonosoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import lmonosoft.hrms.business.abstracts.*;
import lmonosoft.hrms.business.concretes.CheckHelper.JobSeekerCheckHelper;
import lmonosoft.hrms.core.adapters.abstracts.UserCheckService;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.ErrorResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.core.utilities.results.SuccessDataResult;
import lmonosoft.hrms.core.utilities.results.SuccessResult;
import lmonosoft.hrms.dataAccess.abstracts.JobSeekerDao;
import lmonosoft.hrms.entities.concretes.JobSeeker;
import lmonosoft.hrms.entities.dtos.JobSeekerResumeDto;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private UserCheckService userCheckService;
	private EmailService emailService;

	private JobSeekerSkillService seekerSkillService;
	private JobSeekerPictureService seekerPictureService;
	private JobSeekerLinkService seekerLinkService;
	private JobSeekerLanguageService seekerLanguageService;
	private JobSeekerEducationService seekerEducationService;
	private JobSeekerExperienceService seekerExperienceService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserCheckService userCheckService, EmailService emailService,
			JobSeekerSkillService seekerSkillService, JobSeekerPictureService seekerPictureService,
			JobSeekerLinkService seekerLinkService, JobSeekerLanguageService seekerLanguageService,
			JobSeekerEducationService seekerEducationService, JobSeekerExperienceService seekerExperienceService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userCheckService = userCheckService;
		this.emailService = emailService;
		this.seekerSkillService = seekerSkillService;
		this.seekerPictureService = seekerPictureService;
		this.seekerLinkService = seekerLinkService;
		this.seekerLanguageService = seekerLanguageService;
		this.seekerEducationService = seekerEducationService;
		this.seekerExperienceService = seekerExperienceService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}

	@Override
	public Result register(JobSeeker jobSeeker, String passwordConfirm) {
		var isRealPerson = !this.userCheckService.isRealPerson(jobSeeker.getFirstName(), jobSeeker.getLastName(),
				jobSeeker.getNationalId(), jobSeeker.getBirthOfDate());
		var checkEmail = this.jobSeekerDao.findByEmail(jobSeeker.getEmail()).size() != 0;
		var checkNationalId = this.jobSeekerDao.findByNationalId(jobSeeker.getNationalId()).size() != 0;
		var checkPassword = !Objects.equal(passwordConfirm, jobSeeker.getPassword());

		if (isRealPerson || checkEmail || checkNationalId || checkPassword) {
			String errorMessage = "";

			if (isRealPerson) {
				errorMessage = "Mernis Error. Bilgiler doğrulanamadı.";
			}
			if (checkEmail || checkNationalId) {
				errorMessage = "Email adresi veya Kimlik bilgileri zaten mevcut.";
			}

			if (checkPassword) {
				errorMessage = "Parolalar eşleşmiyor.";
			}

			return new ErrorResult("Job Seeker Error: " + errorMessage);
		}
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Job Seeker added and " + emailService.sendEmail(jobSeeker).getMessage());
	}

	@Override
	public DataResult<JobSeeker> getById(int jobSeekerId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findById(jobSeekerId).get());
	}

	@Override
	public DataResult<JobSeekerResumeDto> getResumeByJobSeekerId(int jobSeekerId) {
		JobSeekerResumeDto jobSeekerResumeDto = new JobSeekerResumeDto();
		jobSeekerResumeDto.setJobSeeker(this.getById(jobSeekerId).getData());
		jobSeekerResumeDto.setJobSeekerEducations(
				this.seekerEducationService.getAllByJobSeekerIdOrderByGraduationDateDesc(jobSeekerId).getData());
		jobSeekerResumeDto.setJobSeekerExperiences(
				this.seekerExperienceService.getAllByJobSeekerIdOrderByEndDateDesc(jobSeekerId).getData());
		jobSeekerResumeDto.setJobSeekerLanguages(this.seekerLanguageService.getAllByJobSeekerId(jobSeekerId).getData());
		jobSeekerResumeDto.setJobSeekerLinks(this.seekerLinkService.getAllByJobSeekerId(jobSeekerId).getData());
		jobSeekerResumeDto.setJobSeekerPictures(this.seekerPictureService.getAllByJobSeekerId(jobSeekerId).getData());
		jobSeekerResumeDto.setJobSeekerSkills(this.seekerSkillService.getAllByJobSeekerId(jobSeekerId).getData());
		return new SuccessDataResult<JobSeekerResumeDto>(jobSeekerResumeDto);
	}
}
