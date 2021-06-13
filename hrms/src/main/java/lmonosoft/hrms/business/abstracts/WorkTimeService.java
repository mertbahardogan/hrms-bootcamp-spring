package lmonosoft.hrms.business.abstracts;

import java.util.List;

import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.entities.concretes.WorkTime;

public interface WorkTimeService {
	DataResult<List<WorkTime>> getAll();
}
