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
import org.springframework.web.multipart.MultipartFile;

import lmonosoft.hrms.business.abstracts.JobSeekerPictureService;
import lmonosoft.hrms.entities.concretes.JobSeeker;
import lmonosoft.hrms.entities.concretes.JobSeekerPicture;

@RestController
@RequestMapping("/api/jobseekerpictures/")
public class JobSeekerPicturesController {

	private JobSeekerPictureService seekerPictureService;

	@Autowired
	public JobSeekerPicturesController(JobSeekerPictureService seekerPictureService) {
		super();
		this.seekerPictureService = seekerPictureService;
	}

	@PostMapping("add") // @Valid
	public ResponseEntity<?> add(@RequestBody MultipartFile file, @RequestParam int jobSeekerId) {
		JobSeekerPicture seekerPicture=new JobSeekerPicture();
		JobSeeker jobSeeker=new JobSeeker();
		jobSeeker.setId(jobSeekerId);
		seekerPicture.setJobSeeker(jobSeeker);
		return ResponseEntity.ok(this.seekerPictureService.add(seekerPicture,file));
	}

	@GetMapping("getAllByJobSeekerId")
	public ResponseEntity<?> getAllByJobSeekerId(@RequestParam int jobSeekerId) {
		return ResponseEntity.ok(this.seekerPictureService.getAllByJobSeekerId(jobSeekerId));
	}

}
