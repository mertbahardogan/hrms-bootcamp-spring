package lmonosoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lmonosoft.hrms.business.abstracts.JobSeekerExperienceService;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.core.utilities.results.SuccessDataResult;
import lmonosoft.hrms.core.utilities.results.SuccessResult;
import lmonosoft.hrms.dataAccess.abstracts.JobSeekerExperienceDao;
import lmonosoft.hrms.entities.concretes.JobSeekerExperience;

@Service
public class JobSeekerExperienceManager implements JobSeekerExperienceService {

	private JobSeekerExperienceDao seekerExperienceDao;

	@Autowired
	public JobSeekerExperienceManager(JobSeekerExperienceDao seekerExperienceDao) {
		super();
		this.seekerExperienceDao = seekerExperienceDao;
	}

	@Override
	public Result add(JobSeekerExperience jobSeekerExperience) {
		this.seekerExperienceDao.save(jobSeekerExperience);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobSeekerExperience>> getAll() {
		return new SuccessDataResult<List<JobSeekerExperience>>(seekerExperienceDao.findAll());
	}

	@Override
	public DataResult<List<JobSeekerExperience>> getAllByJobSeekerIdOrderByEndDate(int jobSeekerId) {
		return new SuccessDataResult<List<JobSeekerExperience>>(
				seekerExperienceDao.getAllByJobSeekerIdOrderByEndDate(jobSeekerId));
	}

}
