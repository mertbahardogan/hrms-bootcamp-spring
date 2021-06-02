package lmonosoft.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lmonosoft.hrms.business.abstracts.JobSeekerEducationService;
import lmonosoft.hrms.entities.concretes.JobSeekerEducation;

@RestController
@RequestMapping("/api/jobseekereducations/")
public class JobSeekerEducationsController {

	private JobSeekerEducationService seekerEducationService;

	@Autowired
	public JobSeekerEducationsController(JobSeekerEducationService seekerEducationService) {
		super();
		this.seekerEducationService = seekerEducationService;
	}

	@PostMapping("add") 
	public ResponseEntity<?> add(@RequestBody JobSeekerEducation jobSeekerEducation) {
		return ResponseEntity.ok(this.seekerEducationService.add(jobSeekerEducation));
	}

	@GetMapping("getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.seekerEducationService.getAll());
	}

	@GetMapping("getAllByJobSeekerIdOrderByGraduationDate")
	public ResponseEntity<?> getAllByJobSeekerIdOrderByGraduationDate(@RequestParam int jobSeekerId) {
		return ResponseEntity.ok(this.seekerEducationService.getAllByJobSeekerIdOrderByGraduationDate(jobSeekerId));
	}
}
