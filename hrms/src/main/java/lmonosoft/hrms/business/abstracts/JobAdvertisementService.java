package lmonosoft.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);

	DataResult<List<JobAdvertisement>> getAll();

	DataResult<List<JobAdvertisement>> getByIsActive(); // silinecek

	DataResult<List<JobAdvertisement>> getByIsActiveAndIsApproved();

	DataResult<List<JobAdvertisement>> getByIsActiveAndIsApprovedAndEmployer_Id(int employerId);

	DataResult<List<JobAdvertisement>> getByIsActiveAndReleaseDate(LocalDate releaseDate);

	DataResult<List<JobAdvertisement>> getByIsActiveAndId(int id);

	DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_CompanyName(String companyName);

	Result openJobAdvertisement(int jobAdvertisementId);

	Result closeJobAdvertisement(int jobAdvertisementId);

	DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId);

	DataResult<List<JobAdvertisement>> getAllByIsNotApproved();

	DataResult<List<JobAdvertisement>> getAllByIsApproved();

	Result approveJobAdvertisement(int jobAdvertisementId);

}