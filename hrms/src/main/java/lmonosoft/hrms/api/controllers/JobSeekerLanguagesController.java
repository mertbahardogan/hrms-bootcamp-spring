package lmonosoft.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lmonosoft.hrms.business.abstracts.JobSeekerLanguageService;
import lmonosoft.hrms.entities.concretes.JobSeekerLanguage;

@CrossOrigin
@RestController
@RequestMapping("/api/jobseekerlanguages/")
public class JobSeekerLanguagesController {

	private JobSeekerLanguageService seekerLanguageService;

	public JobSeekerLanguagesController(JobSeekerLanguageService seekerLanguageService) {
		super();
		this.seekerLanguageService = seekerLanguageService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeekerLanguage jobSeekerLanguage) {
		return ResponseEntity.ok(this.seekerLanguageService.add(jobSeekerLanguage));
	}

	@GetMapping("getAllByJobSeekerId")
	public ResponseEntity<?> getAllByJobSeekerId(@RequestParam int jobSeekerId) {
		return ResponseEntity.ok(this.seekerLanguageService.getAllByJobSeekerId(jobSeekerId));
	}
}
