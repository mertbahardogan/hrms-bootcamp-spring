package lmonosoft.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lmonosoft.hrms.entities.concretes.JobSeekerLink;

public interface JobSeekerLinkDao extends JpaRepository<JobSeekerLink, Integer> {

	List<JobSeekerLink> getAllByJobSeekerId(int jobSeekerId);

	JobSeekerLink getById(int jobSeekerId);
}
