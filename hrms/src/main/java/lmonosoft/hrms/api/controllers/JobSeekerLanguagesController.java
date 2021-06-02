package lmonosoft.hrms.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lmonosoft.hrms.business.abstracts.JobSeekerLanguageService;
import lmonosoft.hrms.entities.concretes.JobSeekerLanguage;

@RestController
@RequestMapping("/api/jobseekerlanguages/")
public class JobSeekerLanguagesController {

	private JobSeekerLanguageService seekerLanguageService;

	public JobSeekerLanguagesController(JobSeekerLanguageService seekerLanguageService) {
		super();
		this.seekerLanguageService = seekerLanguageService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody JobSeekerLanguage jobSeekerLanguage) {
		return ResponseEntity.ok(this.seekerLanguageService.add(jobSeekerLanguage));
	}

	@GetMapping("getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.seekerLanguageService.getAll());
	}

	@GetMapping("getAllByJobSeekerId")
	public ResponseEntity<?> getAllByJobSeekerId(@RequestParam int jobSeekerId) {
		return ResponseEntity.ok(this.seekerLanguageService.getAllByJobSeekerId(jobSeekerId));
	}
}
