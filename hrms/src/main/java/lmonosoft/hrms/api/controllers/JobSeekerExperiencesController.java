package lmonosoft.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lmonosoft.hrms.business.abstracts.JobSeekerExperienceService;
import lmonosoft.hrms.entities.concretes.JobSeekerExperience;

@RestController
@RequestMapping("/api/jobseekerexperiences/")
public class JobSeekerExperiencesController {

	private JobSeekerExperienceService seekerExperienceService;

	@Autowired
	public JobSeekerExperiencesController(JobSeekerExperienceService seekerExperienceService) {
		super();
		this.seekerExperienceService = seekerExperienceService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeekerExperience jobSeekerExperience) {
		return ResponseEntity.ok(this.seekerExperienceService.add(jobSeekerExperience));
	}

	@GetMapping("getAllByJobSeekerIdOrderByEndDateDesc")
	public ResponseEntity<?> getAllByJobSeekerIdOrderByEndDateDesc(@RequestParam int jobSeekerId) {
		return ResponseEntity.ok(this.seekerExperienceService.getAllByJobSeekerIdOrderByEndDateDesc(jobSeekerId));
	}

}
