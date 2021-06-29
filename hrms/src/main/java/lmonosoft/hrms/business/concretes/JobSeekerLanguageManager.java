package lmonosoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lmonosoft.hrms.business.abstracts.JobSeekerLanguageService;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.core.utilities.results.SuccessDataResult;
import lmonosoft.hrms.core.utilities.results.SuccessResult;
import lmonosoft.hrms.dataAccess.abstracts.JobSeekerLanguageDao;
import lmonosoft.hrms.entities.concretes.JobSeekerLanguage;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {

	private JobSeekerLanguageDao seekerLanguageDao;

	@Autowired
	public JobSeekerLanguageManager(JobSeekerLanguageDao seekerLanguageDao) {
		super();
		this.seekerLanguageDao = seekerLanguageDao;
	}

	@Override
	public Result add(JobSeekerLanguage jobSeekerLanguage) {
		this.seekerLanguageDao.save(jobSeekerLanguage);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobSeekerLanguage>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<JobSeekerLanguage>>(seekerLanguageDao.getAllByJobSeekerId(jobSeekerId));
	}

	@Override
	public Result update(int id, JobSeekerLanguage jobSeekerLanguage) {
		var seekerLanguage = seekerLanguageDao.getById(id);
		seekerLanguage.setLanguage(jobSeekerLanguage.getLanguage());
		seekerLanguage.setLevel(jobSeekerLanguage.getLevel());
		seekerLanguage.setJobSeeker(jobSeekerLanguage.getJobSeeker());
		this.seekerLanguageDao.save(seekerLanguage);
		return new SuccessResult();
	}

}
