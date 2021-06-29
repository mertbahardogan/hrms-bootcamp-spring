package lmonosoft.hrms.business.abstracts;

import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.entities.concretes.OldEmployer;

public interface OldEmployerService {
	Result add(OldEmployer oldEmployer);
	OldEmployer getbyEmployerid(int id);
}
