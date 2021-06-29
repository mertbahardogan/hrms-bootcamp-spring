package lmonosoft.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import lmonosoft.hrms.entities.concretes.OldEmployer;

public interface OldEmployerDao extends JpaRepository<OldEmployer, Integer>{
	OldEmployer getByEmployer_id(int id);

}
