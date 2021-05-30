package lmonosoft.hrms.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lmonosoft.hrms.business.abstracts.JobAdvertisementService;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/job_advertisements/")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@PostMapping("add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {

		return this.jobAdvertisementService.add(jobAdvertisement);
	}

	@GetMapping("getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}

	@GetMapping("getByIsActive")
	public DataResult<List<JobAdvertisement>> getByIsActive() {
		return this.jobAdvertisementService.getByIsActive();
	}

	@GetMapping("getByIsActiveAndReleaseDate")
	public DataResult<List<JobAdvertisement>> getByIsActiveAndReleaseDate(@RequestParam LocalDate releaseDate) {
		return this.jobAdvertisementService.getByIsActiveAndReleaseDate(releaseDate);
	}

	@GetMapping("getByIsActiveAndEmployer_CompanyName")
	public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_CompanyName(@RequestParam String companyName) {
		return this.jobAdvertisementService.getByIsActiveAndEmployer_CompanyName(companyName);
	}

	@PutMapping("closeJobAdvertisement")
	public Result closeJobAdvertisement(@RequestParam int jobAdvertisementId) {
		return this.jobAdvertisementService.closeJobAdvertisement(jobAdvertisementId);
	}
}
