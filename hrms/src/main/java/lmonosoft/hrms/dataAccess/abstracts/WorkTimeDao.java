package lmonosoft.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lmonosoft.hrms.entities.concretes.WorkTime;



@Repository
public interface WorkTimeDao extends JpaRepository<WorkTime, Integer> {

}
