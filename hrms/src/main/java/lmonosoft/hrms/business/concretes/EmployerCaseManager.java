package lmonosoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lmonosoft.hrms.business.abstracts.EmployerCaseService;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.SuccessDataResult;
import lmonosoft.hrms.dataAccess.abstracts.EmployerCaseDao;
import lmonosoft.hrms.entities.concretes.EmployerCase;

@Service
public class EmployerCaseManager implements EmployerCaseService {

	private EmployerCaseDao employerCaseDao;

	@Autowired
	public EmployerCaseManager(EmployerCaseDao employerCaseDao) {
		super();
		this.employerCaseDao = employerCaseDao;
	}

	@Override
	public DataResult<List<EmployerCase>> getAll() {
		return new SuccessDataResult<List<EmployerCase>>(employerCaseDao.findAll());

	}

}
