package lmonosoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lmonosoft.hrms.business.abstracts.JobPositionService;
import lmonosoft.hrms.business.concretes.CheckHelper.JobPositionCheckHelper;
import lmonosoft.hrms.core.strings.ErrorMessages;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.ErrorResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.core.utilities.results.SuccessDataResult;
import lmonosoft.hrms.core.utilities.results.SuccessResult;
import lmonosoft.hrms.dataAccess.abstracts.JobPositionDao;
import lmonosoft.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
	}

	@Override
	public Result add(JobPosition jobPosition) {

		var checkPositon = this.jobPositionDao.findByName(jobPosition.getName()).size() != 0;
		if (checkPositon) {
			return new ErrorResult("Job Postion name already exist.");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Job Position added.");
	}

}
