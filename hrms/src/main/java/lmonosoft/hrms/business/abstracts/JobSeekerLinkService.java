package lmonosoft.hrms.business.abstracts;

import java.util.List;

import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.entities.concretes.JobSeekerLink;

public interface JobSeekerLinkService {
	Result add(JobSeekerLink jobSeekerLink);

	DataResult<List<JobSeekerLink>> getAllByJobSeekerId(int jobSeekerId);

}
