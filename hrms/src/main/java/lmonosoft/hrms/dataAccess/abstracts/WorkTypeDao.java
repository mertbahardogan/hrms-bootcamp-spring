package lmonosoft.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lmonosoft.hrms.entities.concretes.WorkType;

@Repository
public interface WorkTypeDao extends JpaRepository<WorkType, Integer>{

	
}
