package lmonosoft.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lmonosoft.hrms.business.abstracts.JobPositionService;
import lmonosoft.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/job_positions")
public class JobPositionController {
	
	private JobPositionService positionService;

	@Autowired
	public JobPositionController(JobPositionService positionService) {
		super();
		this.positionService = positionService;
	}
	
	@GetMapping("/getAll")
	public List<JobPosition> getAll() {
		return this.positionService.getAll();
	}
	
	
	
	
	

}
