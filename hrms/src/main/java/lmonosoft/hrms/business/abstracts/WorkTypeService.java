package lmonosoft.hrms.business.abstracts;

import java.util.List;

import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.entities.concretes.WorkType;

public interface WorkTypeService {

	DataResult<List<WorkType>> getAll();
}
