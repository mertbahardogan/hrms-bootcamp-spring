package lmonosoft.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lmonosoft.hrms.business.abstracts.OldEmployerService;
import lmonosoft.hrms.core.utilities.results.SuccessResult;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.core.utilities.results.SuccessDataResult;
import lmonosoft.hrms.dataAccess.abstracts.OldEmployerDao;
import lmonosoft.hrms.entities.concretes.OldEmployer;

@Service
public class OldEmployerManager implements OldEmployerService {

	private OldEmployerDao oldEmployerDao;

	@Autowired
	public OldEmployerManager(OldEmployerDao oldEmployerDao) {
		super();
		this.oldEmployerDao = oldEmployerDao;
	}

	@Override
	public Result add(OldEmployer oldEmployer) {
		this.oldEmployerDao.save(oldEmployer);
		return new SuccessResult();
	}
	
	@Override
    public OldEmployer getbyEmployerid(int id) {
        return oldEmployerDao.getByEmployer_id(id);
    }

}
