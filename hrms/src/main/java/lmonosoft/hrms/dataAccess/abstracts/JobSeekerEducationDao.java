package lmonosoft.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lmonosoft.hrms.entities.concretes.JobSeekerEducation;
import lmonosoft.hrms.entities.concretes.JobSeekerExperience;

public interface JobSeekerEducationDao extends JpaRepository<JobSeekerEducation, Integer> {

	List<JobSeekerEducation> getAllByJobSeekerIdOrderByGraduationDateDesc(int jobSeekerId);

	JobSeekerEducation getById(int jobSeekerId);

}
