package lmonosoft.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lmonosoft.hrms.business.abstracts.PersonnelService;
import lmonosoft.hrms.entities.concretes.Personnel;

@RestController
@RequestMapping("/api/personnels")
public class PersonnelController {

	private PersonnelService personnelService;

	@Autowired
	public PersonnelController(PersonnelService personnelService) {
		super();
		this.personnelService = personnelService;
	}

	@GetMapping("/getAll")
	public List<Personnel> getAll() {
		return this.personnelService.getAll();
	}

}
