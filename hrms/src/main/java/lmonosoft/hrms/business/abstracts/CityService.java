package lmonosoft.hrms.business.abstracts;

import java.util.List;

import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();
}
