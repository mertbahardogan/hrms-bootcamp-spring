package lmonosoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lmonosoft.hrms.business.abstracts.CityService;
import lmonosoft.hrms.core.strings.SuccessMessages;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.SuccessDataResult;
import lmonosoft.hrms.dataAccess.abstracts.CityDao;
import lmonosoft.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), SuccessMessages.dataListed);
	}

}
