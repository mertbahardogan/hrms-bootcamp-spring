package lmonosoft.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lmonosoft.hrms.entities.concretes.JobSeekerEducation;

public interface JobSeekerEducationDao extends JpaRepository<JobSeekerEducation, Integer> {

	List<JobSeekerEducation> getAllByJobSeekerIdOrderByGraduationDateDesc(int jobSeekerId);
}
