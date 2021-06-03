package lmonosoft.hrms.business.abstracts;

import java.util.List;

import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.entities.concretes.JobSeekerEducation;

public interface JobSeekerEducationService {
	Result add(JobSeekerEducation jobSeekerEducation);

	DataResult<List<JobSeekerEducation>> getAllByJobSeekerIdOrderByGraduationDateDesc(int jobSeekerId);
}
