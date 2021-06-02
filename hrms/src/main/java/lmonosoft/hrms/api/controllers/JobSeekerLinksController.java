package lmonosoft.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lmonosoft.hrms.business.abstracts.JobSeekerLinkService;
import lmonosoft.hrms.entities.concretes.JobSeekerLink;

@RestController
@RequestMapping("/api/jobseekerlinks/")
public class JobSeekerLinksController {

	private JobSeekerLinkService seekerLinkService;

	@Autowired
	public JobSeekerLinksController(JobSeekerLinkService seekerLinkService) {
		super();
		this.seekerLinkService = seekerLinkService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody JobSeekerLink jobSeekerLink) {
		return ResponseEntity.ok(this.seekerLinkService.add(jobSeekerLink));
	}

	@GetMapping("getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.seekerLinkService.getAll());
	}

	@GetMapping("getAllByJobSeekerId")
	public ResponseEntity<?> getAllByJobSeekerId(@RequestParam int jobSeekerId) {
		return ResponseEntity.ok(this.seekerLinkService.getAllByJobSeekerId(jobSeekerId));
	}

}
