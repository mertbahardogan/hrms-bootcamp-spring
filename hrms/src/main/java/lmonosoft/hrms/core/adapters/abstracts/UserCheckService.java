package lmonosoft.hrms.core.adapters.abstracts;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public interface UserCheckService {

	boolean isRealPerson(String firstName, String lastName, String nationalId, LocalDate birthOfDate);

}
