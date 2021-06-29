package lmonosoft.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lmonosoft.hrms.business.abstracts.EmployerCaseService;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.entities.concretes.EmployerCase;

@CrossOrigin
@RestController
@RequestMapping("/api/employerCases/")
public class EmployerCasesController {

	private EmployerCaseService employerCaseService;

	@Autowired
	public EmployerCasesController(EmployerCaseService employerCaseService) {
		super();
		this.employerCaseService = employerCaseService;
	}

	@GetMapping("getall")
	public DataResult<List<EmployerCase>> getAll() {
		return employerCaseService.getAll();
	}
}
