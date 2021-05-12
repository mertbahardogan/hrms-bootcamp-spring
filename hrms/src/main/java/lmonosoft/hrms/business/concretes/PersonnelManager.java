package lmonosoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lmonosoft.hrms.business.abstracts.PersonnelService;
import lmonosoft.hrms.dataAccess.abstracts.PersonnelDao;
import lmonosoft.hrms.entities.concretes.Personnel;

@Service
public class PersonnelManager implements PersonnelService {

	private PersonnelDao personnelDao;

	@Autowired
	public PersonnelManager(PersonnelDao personnelDao) {
		super();
		this.personnelDao = personnelDao;
	}

	@Override
	public List<Personnel> getAll() {
		return personnelDao.findAll();
	}

}
