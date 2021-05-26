package lmonosoft.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lmonosoft.hrms.business.abstracts.JobPositionService;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
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
	public DataResult<List<JobPosition>> getAll() {
		return this.positionService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPosition) {
		return this.positionService.add(jobPosition);
	}

}
