package lmonosoft.hrms.business.abstracts;

import java.util.List;

import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.entities.concretes.JobSeekerExperience;

public interface JobSeekerExperienceService {

	Result add(JobSeekerExperience jobSeekerExperience);

	DataResult<List<JobSeekerExperience>> getAllByJobSeekerIdOrderByEndDateDesc(int jobSeekerId);

}
