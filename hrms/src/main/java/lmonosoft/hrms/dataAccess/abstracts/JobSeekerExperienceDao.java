package lmonosoft.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import lmonosoft.hrms.entities.concretes.JobSeekerExperience;

public interface JobSeekerExperienceDao extends JpaRepository<JobSeekerExperience, Integer> {

	List<JobSeekerExperience> getAllByJobSeekerIdOrderByEndDateDesc(int jobSeekerID);

	JobSeekerExperience getById(int jobSeekerId);


}
