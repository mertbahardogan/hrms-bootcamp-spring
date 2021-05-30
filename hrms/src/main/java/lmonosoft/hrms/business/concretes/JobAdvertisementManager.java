package lmonosoft.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lmonosoft.hrms.business.abstracts.JobAdvertisementService;
import lmonosoft.hrms.business.concretes.CheckHelper.JobAdvertisementCheckHelper;
import lmonosoft.hrms.business.strings.ErrorMessages;
import lmonosoft.hrms.business.strings.SuccessMessages;
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
	public Result closeJobAdvertisement(int jobAdvertisementId) {

		JobAdvertisement setAdvertisement = this.jobAdvertisementDao.getOne(jobAdvertisementId);
		setAdvertisement.setActive(false);

		this.jobAdvertisementDao.save(setAdvertisement);
		return new SuccessResult(SuccessMessages.dataUpdated);
	}

}
