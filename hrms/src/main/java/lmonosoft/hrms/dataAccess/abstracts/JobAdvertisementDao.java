package lmonosoft.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lmonosoft.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByIsActive(boolean isActive);

	List<JobAdvertisement> getByIsActiveAndReleaseDate(boolean isActive, LocalDate releaseDate);

	List<JobAdvertisement> getByIsActiveAndEmployer_CompanyName(boolean isActive, String companyName);
}
