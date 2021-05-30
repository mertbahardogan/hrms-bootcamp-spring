package lmonosoft.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);

	DataResult<List<JobAdvertisement>> getAll();

	DataResult<List<JobAdvertisement>> getByIsActive();

	DataResult<List<JobAdvertisement>> getByIsActiveAndReleaseDate(LocalDate releaseDate);

	DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_CompanyName(String companyName);
	
    Result closeJobAdvertisement(int jobAdvertisementId);

}