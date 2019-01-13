package p1.service;

import java.util.List;

import p1.model.Role;
import p1.model.User;

public interface UserService {
	List<User> userList();
	User findOne(Long id);
	User addUser(User user);
	String deleteUser(Long id);
	List<Role> findAllRole();
}
