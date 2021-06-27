package lmonosoft.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lmonosoft.hrms.business.abstracts.JobSeekerEducationService;
import lmonosoft.hrms.entities.concretes.JobSeekerEducation;
import lmonosoft.hrms.entities.concretes.JobSeekerExperience;

@CrossOrigin
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
	public ResponseEntity<?> add(@Valid @RequestBody JobSeekerEducation jobSeekerEducation) {
		return ResponseEntity.ok(this.seekerEducationService.add(jobSeekerEducation));
	}

	@GetMapping("getAllByJobSeekerIdOrderByGraduationDateDesc")
	public ResponseEntity<?> getAllByJobSeekerIdOrderByGraduationDateDesc(@RequestParam int jobSeekerId) {
		return ResponseEntity.ok(this.seekerEducationService.getAllByJobSeekerIdOrderByGraduationDateDesc(jobSeekerId));
	}
	
	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestParam int id, @RequestBody JobSeekerEducation jobSeekerEducation) {
		return ResponseEntity.ok(this.seekerEducationService.update(id, jobSeekerEducation));
	}
}
