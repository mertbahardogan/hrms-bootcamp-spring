package lmonosoft.hrms.api.controllers;

import java.util.List;

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

import lmonosoft.hrms.business.abstracts.EmployerService;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.entities.concretes.Employer;
import lmonosoft.hrms.entities.concretes.EmployerCase;

@CrossOrigin
@RestController
@RequestMapping("/api/employers/")
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}

	@GetMapping("getAll")
	public DataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}

	@GetMapping("getEmployerById")
	public DataResult<List<Employer>> getEmployerById(@RequestParam int id) {
		return this.employerService.getEmployerById(id);
	}

	@PostMapping("register")
	public Result register(@RequestBody Employer employer, String passwordConfirm) {
		return this.employerService.register(employer, passwordConfirm);
	}

	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestParam int id, @RequestBody Employer employer) {
		return ResponseEntity.ok(this.employerService.update(id, employer));
	}
	
	@PostMapping("ConfirmUpdate")
    public Result ConfirmUpdate(@RequestBody EmployerCase employerCase,@RequestParam int EmployerId) {
        return this.employerService.ConfirmUpdate(employerCase,EmployerId);
    }
	
	@GetMapping("getByIdForUsers")
    public DataResult<List<Employer>> getByIdForUsers(int id){
         return this.employerService.getByIdForUsers(id);
    }
    @GetMapping("getByIdForAdmins")
    public DataResult<List<Employer>> getByIdForAdmins(int id){
         return this.employerService.getByIdForAdmins(id);
    }

    @GetMapping("getByEmployerCaseId")
    public DataResult<List<Employer>> getByEmployerCase_id() {
        return this.employerService.getByEmployerCase_id();
    }

}
