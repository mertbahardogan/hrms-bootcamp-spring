package lmonosoft.hrms.business.abstracts;

import java.util.List;

import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.entities.concretes.JobSeekerPicture;
import lmonosoft.hrms.entities.concretes.JobSeekerSkill;

public interface JobSeekerPictureService {

	Result add(JobSeekerPicture jobSeekerPicture);

	DataResult<List<JobSeekerPicture>> getAllByJobSeekerId(int jobSeekerId);
}
