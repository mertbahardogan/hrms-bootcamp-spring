package lmonosoft.hrms.entities.dtos;

import java.util.List;

import lmonosoft.hrms.entities.concretes.JobSeeker;
import lmonosoft.hrms.entities.concretes.JobSeekerEducation;
import lmonosoft.hrms.entities.concretes.JobSeekerExperience;
import lmonosoft.hrms.entities.concretes.JobSeekerLanguage;
import lmonosoft.hrms.entities.concretes.JobSeekerLink;
import lmonosoft.hrms.entities.concretes.JobSeekerPicture;
import lmonosoft.hrms.entities.concretes.JobSeekerSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerResumeDto {
	private JobSeeker jobSeeker;
	private List<JobSeekerSkill> jobSeekerSkills;
	private List<JobSeekerPicture> jobSeekerPictures;
	private List<JobSeekerLink> jobSeekerLinks;
	private List<JobSeekerLanguage> jobSeekerLanguages;
	private List<JobSeekerExperience> jobSeekerExperiences;
	private List<JobSeekerEducation> jobSeekerEducations;
}
