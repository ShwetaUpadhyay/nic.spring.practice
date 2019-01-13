package p1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import p1.model.User;
import p1.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public String login(Model model,String error,String logout){
		if(error!=null) {
			model.addAttribute("error", "Your username and password are invalid");
		}
		if(logout!=null) {
			model.addAttribute("message", "You have been logged out successfully");
		}
		return "login";
	}
	
	@GetMapping("/form")
	public String userForm(Model model) {
		model.addAttribute("userForm",new User());
		model.addAttribute("roles", userService.findAllRole());
		return "user/form";
	}
	
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable Long id,Model model){
		model.addAttribute("userForm",userService.findOne(id));
		return "user/form";
		
	}
	@RequestMapping("/list/{id}")
	public User findOne(@PathVariable Long id) {
		return userService.findOne(id);	
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String addUser(@ModelAttribute User user,Model model) {
		String message="";
		if(user.getId()==null) {
			message="added";
		}else
		{
			message="updated";
		}
		model.addAttribute("message",userService.addUser(user).getUserName()  +  message + " successfully ");
		return "message";
	}
	
	@RequestMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String deleteUser(@PathVariable Long id,Model model) {
		model.addAttribute("message",userService.deleteUser(id));
		return "message";
		
	}
	@GetMapping("/list")
	@PreAuthorize("hasRole('ROLE_USER')or hasRole('ROLE_ADMIN')")
	public String userList(Model model){
		model.addAttribute("users",userService.userList());
		return "/user/list";
		
	}
	
	
}
