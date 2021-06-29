package lmonosoft.hrms.business.abstracts;

import java.util.List;

import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.entities.concretes.Employer;
import lmonosoft.hrms.entities.concretes.EmployerCase;
import lmonosoft.hrms.entities.concretes.JobSeekerExperience;

public interface EmployerService {
	DataResult<List<Employer>> getAll();

	DataResult<List<Employer>> getEmployerById(int id);
	
	Result register(Employer employer, String passwordConfirm);
	
	Result update(int id,Employer employer);
	
	Result ConfirmUpdate(EmployerCase employerCase,int EmployerId);

	DataResult<List<Employer>> getByIdForUsers(int id);
	
    DataResult<List<Employer>> getByIdForAdmins(int id);

    DataResult<List<Employer>> getByEmployerCase_id();

}
