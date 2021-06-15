package lmonosoft.hrms.api.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lmonosoft.hrms.business.abstracts.JobAdvertisementService;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.ErrorDataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.entities.concretes.JobAdvertisement;

@CrossOrigin
@RestController
@RequestMapping("/api/job_advertisements/")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement) {
		return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
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
	public DataResult<List<JobAdvertisement>> getByIsActiveAndReleaseDate(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate releaseDate) {
		return this.jobAdvertisementService.getByIsActiveAndReleaseDate(releaseDate);
	}

	@GetMapping("getByIsActiveAndEmployer_CompanyName")
	public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_CompanyName(@RequestParam String companyName) {
		return this.jobAdvertisementService.getByIsActiveAndEmployer_CompanyName(companyName);
	}

	@PutMapping("openJobAdvertisement")
	public Result openJobAdvertisement(@RequestParam int jobAdvertisementId) {
		return this.jobAdvertisementService.openJobAdvertisement(jobAdvertisementId);
	}
	
	@PutMapping("closeJobAdvertisement")
	public Result closeJobAdvertisement(@RequestParam int jobAdvertisementId) {
		return this.jobAdvertisementService.closeJobAdvertisement(jobAdvertisementId);
	}
	
	@GetMapping("getAllByEmployerId")
	public DataResult<List<JobAdvertisement>> getAllByEmployerId(@RequestParam int employerId) {
		return this.jobAdvertisementService.getAllByEmployerId(employerId);
	}
	
	@GetMapping("getAllByIsNotApproved")
	public DataResult<List<JobAdvertisement>> getAllByIsNotApproved() {
		return this.jobAdvertisementService.getAllByIsNotApproved();
	}
	
	@GetMapping("getAllByIsApproved")
	public DataResult<List<JobAdvertisement>> getAllByIsApproved() {
		return this.jobAdvertisementService.getAllByIsApproved();
	}
	
	@PutMapping("approveJobAdvertisement")
	public Result approveJobAdvertisement(@RequestParam int jobAdvertisementId) {
		return this.jobAdvertisementService.approveJobAdvertisement(jobAdvertisementId);
	}
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {

		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Validation ERROR");
		return errors;
	}
}
