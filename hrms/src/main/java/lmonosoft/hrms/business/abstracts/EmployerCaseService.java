package lmonosoft.hrms.business.abstracts;

import java.util.List;

import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.entities.concretes.EmployerCase;

public interface EmployerCaseService {
	DataResult<List<EmployerCase>> getAll();

}
