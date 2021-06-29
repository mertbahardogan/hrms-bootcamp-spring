package lmonosoft.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lmonosoft.hrms.business.abstracts.OldEmployerService;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.entities.concretes.OldEmployer;

@CrossOrigin
@RestController
@RequestMapping("/api/oldEmployers/")
public class OldEmployersController {

	private OldEmployerService oldEmployerService;

	@Autowired
	public OldEmployersController(OldEmployerService oldEmployerService) {
		super();
		this.oldEmployerService = oldEmployerService;
	}

	@GetMapping("getbyEmployerid")
	public OldEmployer getbyEmployerid(int id) {
		return this.oldEmployerService.getbyEmployerid(id);
	}

}
