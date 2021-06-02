package lmonosoft.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import lmonosoft.hrms.business.abstracts.JobSeekerPictureService;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.entities.concretes.JobSeekerPicture;
import lmonosoft.hrms.entities.concretes.JobSeekerSkill;

@Service
public class JobSeekerPictureManager implements JobSeekerPictureService {

	private JobSeekerPictureService seekerPictureService;

	public JobSeekerPictureManager(JobSeekerPictureService seekerPictureService) {
		super();
		this.seekerPictureService = seekerPictureService;
	}

	@Override
	public Result add(JobSeekerPicture jobSeekerPicture) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobSeekerPicture>> getAllByJobSeekerId(int jobSeekerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
