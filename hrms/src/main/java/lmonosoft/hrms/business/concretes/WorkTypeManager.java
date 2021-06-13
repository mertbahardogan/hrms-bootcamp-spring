package lmonosoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lmonosoft.hrms.business.abstracts.WorkTypeService;
import lmonosoft.hrms.core.strings.SuccessMessages;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.SuccessDataResult;
import lmonosoft.hrms.dataAccess.abstracts.WorkTypeDao;
import lmonosoft.hrms.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService {

	private WorkTypeDao workTypeDao;

	@Autowired
	public WorkTypeManager(WorkTypeDao workTypeDao) {
		super();
		this.workTypeDao = workTypeDao;
	}

	@Override
	public DataResult<List<WorkType>> getAll() {
		return new SuccessDataResult<List<WorkType>>(this.workTypeDao.findAll(), SuccessMessages.dataListed);
	}

}
