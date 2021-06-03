package lmonosoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lmonosoft.hrms.business.abstracts.JobSeekerEducationService;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.core.utilities.results.SuccessDataResult;
import lmonosoft.hrms.core.utilities.results.SuccessResult;
import lmonosoft.hrms.dataAccess.abstracts.JobSeekerEducationDao;
import lmonosoft.hrms.entities.concretes.JobSeekerEducation;

@Service
public class JobSeekerEducationManager implements JobSeekerEducationService {

	private JobSeekerEducationDao seekerEducationDao;

	@Autowired
	public JobSeekerEducationManager(JobSeekerEducationDao seekerEducationDao) {
		super();
		this.seekerEducationDao = seekerEducationDao;
	}

	@Override
	public Result add(JobSeekerEducation jobSeekerEducation) {
		this.seekerEducationDao.save(jobSeekerEducation);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobSeekerEducation>> getAllByJobSeekerIdOrderByGraduationDateDesc(int jobSeekerId) {

		return new SuccessDataResult<List<JobSeekerEducation>>(
				seekerEducationDao.getAllByJobSeekerIdOrderByGraduationDateDesc(jobSeekerId));
	}

}
