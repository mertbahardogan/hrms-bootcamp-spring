package lmonosoft.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lmonosoft.hrms.entities.concretes.Employer;
import lmonosoft.hrms.entities.concretes.User;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {
	List<Employer> findByEmail(String email);

	List<Employer> getEmployerById(int id);
	
	List<Employer> getByEmployerCase_id(int id);
}
