package lmonosoft.hrms.business.abstracts;

import java.util.List;

import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.entities.concretes.JobSeekerSkill;

public interface JobSeekerSkillService {

	Result add(JobSeekerSkill jobSeekerSkill);


	DataResult<List<JobSeekerSkill>> getAllByJobSeekerId(int jobSeekerId);
}
