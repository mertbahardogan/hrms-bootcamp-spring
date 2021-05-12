package lmonosoft.hrms.business.abstracts;

import java.util.List;

import lmonosoft.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {

	List<JobSeeker> getAll();

}