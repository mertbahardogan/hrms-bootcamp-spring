package lmonosoft.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lmonosoft.hrms.entities.concretes.JobSeeker;
import lmonosoft.hrms.entities.dtos.JobSeekerResumeDto;

@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	List<JobSeeker> findByEmail(String email);

	List<JobSeeker> findByNationalId(String nationalId);
	
	List<JobSeeker> findById(int id);
	
//	List<JobSeekerResumeDto> getResumeByJobSeekerId(int jobSeekerId);
}
