package lmonosoft.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import lmonosoft.hrms.entities.concretes.EmployerCase;

public interface EmployerCaseDao extends JpaRepository<EmployerCase, Integer>{

}
