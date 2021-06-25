package lmonosoft.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lmonosoft.hrms.business.abstracts.JobSeekerService;
import lmonosoft.hrms.entities.concretes.JobSeeker;

@CrossOrigin
@RestController
@RequestMapping("/api/job_seekers/")
public class JobSeekersController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}

	@PostMapping("register")
	public ResponseEntity<?> register(@Valid @RequestBody JobSeeker jobSeeker, String passwordConfirm) {
		return ResponseEntity.ok(this.jobSeekerService.register(jobSeeker, passwordConfirm));
	}

	@GetMapping("getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.jobSeekerService.getAll());
	}

	@GetMapping("getById")
	public ResponseEntity<?> getById(@RequestParam int jobSeekerId) {
		return ResponseEntity.ok(this.jobSeekerService.getById(jobSeekerId));
	}

	@GetMapping("getResumeByJobSeekerId")
	public ResponseEntity<?> getResumeByJobSeekerId(@RequestParam int jobSeekerId) {
		return ResponseEntity.ok(this.jobSeekerService.getResumeByJobSeekerId(jobSeekerId));
	}

}
