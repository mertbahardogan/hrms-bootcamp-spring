package lmonosoft.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lmonosoft.hrms.entities.concretes.JobAdvertisement;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	
	@Query("FROM JobAdvertisement where isActive = True")
	List<JobAdvertisement> getByIsActive();

	@Query("FROM JobAdvertisement where isActive = True and releaseDate=:releaseDate")
	List<JobAdvertisement> getByIsActiveAndReleaseDate(LocalDate releaseDate);

	@Query("FROM JobAdvertisement where isActive = True and employer.companyName=:companyName")
	List<JobAdvertisement> getByIsActiveAndEmployer_CompanyName(String companyName);
	
	
}
