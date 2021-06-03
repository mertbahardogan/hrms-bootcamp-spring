package lmonosoft.hrms.business.abstracts;

import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.entities.concretes.JobSeekerLanguage;

import java.util.List;

public interface JobSeekerLanguageService {
	Result add(JobSeekerLanguage jobSeekerLanguage);

	DataResult<List<JobSeekerLanguage>> getAllByJobSeekerId(int jobSeekerId);

}
