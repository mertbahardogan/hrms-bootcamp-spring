package lmonosoft.hrms.business.abstracts;

import java.util.List;

import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();

}
