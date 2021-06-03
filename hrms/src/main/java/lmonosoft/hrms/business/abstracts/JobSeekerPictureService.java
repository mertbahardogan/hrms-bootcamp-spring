package lmonosoft.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.entities.concretes.JobSeekerPicture;

public interface JobSeekerPictureService {

	Result add(JobSeekerPicture jobSeekerPicture);

	Result add(JobSeekerPicture jobSeekerPicture, MultipartFile file);

	DataResult<List<JobSeekerPicture>> getAll();

	DataResult<List<JobSeekerPicture>> getAllByJobSeekerId(int jobSeekerId);

}
