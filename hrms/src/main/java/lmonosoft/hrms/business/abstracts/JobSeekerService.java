package lmonosoft.hrms.business.abstracts;

import java.util.List;

import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.entities.concretes.JobSeeker;
import lmonosoft.hrms.entities.dtos.JobSeekerResumeDto;

public interface JobSeekerService {

	DataResult<List<JobSeeker>> getAll();

	Result register(JobSeeker jobSeeker, String passwordConfirm);

	DataResult<JobSeekerResumeDto> getResumeByJobSeekerId(int jobSeekerId);
	
	DataResult<List<JobSeeker>> getById(int jobSeekerId);
}