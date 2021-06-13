package lmonosoft.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lmonosoft.hrms.business.abstracts.WorkTimeService;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.entities.concretes.WorkTime;

@CrossOrigin
@RestController
@RequestMapping("/api/worktimes/")
public class WorkTimesController {

	private WorkTimeService workTimeService;

	@Autowired
	public WorkTimesController(WorkTimeService workTimeService) {
		super();
		this.workTimeService = workTimeService;
	}

	@GetMapping("getAll")
	public DataResult<List<WorkTime>> getAll() {
		return this.workTimeService.getAll();
	}

}
