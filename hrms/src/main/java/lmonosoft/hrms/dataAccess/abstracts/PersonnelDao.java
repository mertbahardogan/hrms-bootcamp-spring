package lmonosoft.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import lmonosoft.hrms.entities.concretes.Personnel;

public interface PersonnelDao extends JpaRepository<Personnel, Integer>{

}
