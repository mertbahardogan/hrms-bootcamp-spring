package lmonosoft.hrms.business.abstracts;

import java.util.List;

import lmonosoft.hrms.entities.concretes.User;

public interface UserService {

	List<User> getAll();

}
