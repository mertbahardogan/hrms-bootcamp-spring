package lmonosoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lmonosoft.hrms.business.abstracts.JobSeekerLinkService;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.core.utilities.results.SuccessDataResult;
import lmonosoft.hrms.core.utilities.results.SuccessResult;
import lmonosoft.hrms.dataAccess.abstracts.JobSeekerLinkDao;
import lmonosoft.hrms.entities.concretes.JobSeekerLink;

@Service
public class JobSeekerLinkManager implements JobSeekerLinkService {

	private JobSeekerLinkDao seekerLinkDao;

	@Autowired
	public JobSeekerLinkManager(JobSeekerLinkDao seekerLinkDao) {
		super();
		this.seekerLinkDao = seekerLinkDao;
	}

	@Override
	public Result add(JobSeekerLink jobSeekerLink) {
		this.seekerLinkDao.save(jobSeekerLink);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobSeekerLink>> getAll() {
		return new SuccessDataResult<List<JobSeekerLink>>(seekerLinkDao.findAll());
	}

	@Override
	public DataResult<List<JobSeekerLink>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<JobSeekerLink>>(seekerLinkDao.getAllByJobSeekerId(jobSeekerId));
	}

}
