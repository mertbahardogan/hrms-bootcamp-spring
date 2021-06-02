package lmonosoft.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lmonosoft.hrms.entities.concretes.JobSeekerLink;
import lmonosoft.hrms.entities.concretes.JobSeekerPicture;

public interface JobSeekerPictureDao extends JpaRepository<JobSeekerPicture, Integer> {
	List<JobSeekerLink> getAllByJobSeekerId(int jobSeekerId);
}
