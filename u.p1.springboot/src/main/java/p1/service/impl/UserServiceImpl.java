package p1.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import p1.model.Role;
import p1.model.User;
import p1.repository.RoleRepository;
import p1.repository.UserRepository;
import p1.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository,RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	@Override
	public List<User> userList() {
		return userRepository.findAll();
	}
	
	@Override
	public User findOne(Long id) {
		return userRepository.findById(id).get();
	}
	
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public String deleteUser(Long id) {
		userRepository.deleteById(id);
		return "user deleted successfully";
	}
	
	@Override
	public List<Role> findAllRole(){
		return roleRepository.findAll();
	}
}
