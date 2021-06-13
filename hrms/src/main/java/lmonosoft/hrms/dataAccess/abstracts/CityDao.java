package lmonosoft.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lmonosoft.hrms.entities.concretes.City;

@Repository
public interface CityDao extends JpaRepository<City, Integer> {

}
