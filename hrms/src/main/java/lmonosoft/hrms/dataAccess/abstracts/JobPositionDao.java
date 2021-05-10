package lmonosoft.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import lmonosoft.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{

}
