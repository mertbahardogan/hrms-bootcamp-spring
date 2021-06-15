package lmonosoft.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lmonosoft.hrms.business.abstracts.JobAdvertisementService;
import lmonosoft.hrms.business.concretes.CheckHelper.JobAdvertisementCheckHelper;
import lmonosoft.hrms.core.strings.ErrorMessages;
import lmonosoft.hrms.core.strings.SuccessMessages;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.ErrorResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.core.utilities.results.SuccessDataResult;
import lmonosoft.hrms.core.utilities.results.SuccessResult;
import lmonosoft.hrms.dataAccess.abstracts.JobAdvertisementDao;
import lmonosoft.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		var checkFields = !JobAdvertisementCheckHelper.isFillAllFields(jobAdvertisement);
		if (checkFields) {
			return new ErrorResult(ErrorMessages.IsFillFields);
		}

		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult(SuccessMessages.dataAdded);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),
				SuccessMessages.dataListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActive(),
				SuccessMessages.dataListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndReleaseDate(LocalDate releaseDate) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByIsActiveAndReleaseDate(releaseDate), SuccessMessages.dataListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByIsActiveAndEmployer_CompanyName(companyName), SuccessMessages.dataListed);
	}
	
	@Override
	public Result openJobAdvertisement(int jobAdvertisementId) {
		JobAdvertisement setAdvertisement = this.jobAdvertisementDao.getOne(jobAdvertisementId);
		setAdvertisement.setActive(true);

		this.jobAdvertisementDao.save(setAdvertisement);
		return new SuccessResult(SuccessMessages.dataUpdated);
	}

	@Override
	public Result closeJobAdvertisement(int jobAdvertisementId) {
		JobAdvertisement setAdvertisement = this.jobAdvertisementDao.getOne(jobAdvertisementId);
		setAdvertisement.setActive(false);

		this.jobAdvertisementDao.save(setAdvertisement);
		return new SuccessResult(SuccessMessages.dataUpdated);
	}


	@Override
	public DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByEmployerId(employerId),
				SuccessMessages.dataListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsNotApproved() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByIsNotApproved(),
				SuccessMessages.dataListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsApproved() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByIsApproved(),
				SuccessMessages.dataListed);
	}

	@Override
	public Result approveJobAdvertisement(int jobAdvertisementId) {

		JobAdvertisement setAdvertisement = this.jobAdvertisementDao.getOne(jobAdvertisementId);
		setAdvertisement.setApproved(true);

		this.jobAdvertisementDao.save(setAdvertisement);
		return new SuccessResult(SuccessMessages.dataUpdated);
	}

}
