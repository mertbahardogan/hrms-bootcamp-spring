package lmonosoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lmonosoft.hrms.business.abstracts.JobSeekerSkillService;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.core.utilities.results.SuccessDataResult;
import lmonosoft.hrms.core.utilities.results.SuccessResult;
import lmonosoft.hrms.dataAccess.abstracts.JobSeekerSkillDao;
import lmonosoft.hrms.entities.concretes.JobSeekerSkill;

@Service
public class JobSeekerSkillManager implements JobSeekerSkillService {

	private JobSeekerSkillDao seekerSkillDao;

	@Autowired
	public JobSeekerSkillManager(JobSeekerSkillDao seekerSkillDao) {
		super();
		this.seekerSkillDao = seekerSkillDao;
	}

	@Override
	public Result add(JobSeekerSkill jobSeekerSkill) {
		this.seekerSkillDao.save(jobSeekerSkill);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobSeekerSkill>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<JobSeekerSkill>>(seekerSkillDao.getAllByJobSeekerId(jobSeekerId));
	}

}
