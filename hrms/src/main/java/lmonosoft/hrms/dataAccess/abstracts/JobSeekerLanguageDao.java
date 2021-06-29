package lmonosoft.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lmonosoft.hrms.entities.concretes.JobSeekerLanguage;

public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage, Integer> {
	List<JobSeekerLanguage> getAllByJobSeekerId(int jobSeekerId);

	JobSeekerLanguage getById(int jobSeekerId);

}
