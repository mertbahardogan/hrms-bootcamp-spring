package lmonosoft.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lmonosoft.hrms.entities.concretes.Employer;
import lmonosoft.hrms.entities.concretes.User;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	List<Employer> findByEmail(String email);
}
