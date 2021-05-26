package lmonosoft.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lmonosoft.hrms.entities.concretes.JobSeeker;

@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	List<JobSeeker> findByEmail(String email);

	List<JobSeeker> findByNationalId(String nationalId);

}
