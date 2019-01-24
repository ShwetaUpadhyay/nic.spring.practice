package p1.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import p1.model.Address;
import p1.service.AddressService;
import p1.service.UserService;

@Controller
@RequestMapping("/address")
public class AddressController {
	private AddressService addressService;
	private UserService userService;
	
		@Autowired
		public AddressController(AddressService addressService,UserService userService) {
		this.addressService = addressService;
		this.userService=userService;
		}
		
		@GetMapping("/form")
		public String addressForm(Model model) {
			model.addAttribute("addressForm",new Address());
			model.addAttribute("users", userService.userList());
			return "address/form";
		}
		
		@GetMapping("/edit/{id}")
		public String editAddress(@PathVariable Long id,Model model){
			model.addAttribute("addressForm",addressService.findOne(id));
			return "address/form";
		}
			
		@GetMapping("/list")
		public String addressList(Model model){
			model.addAttribute("addresses",addressService.addressList());
			return "address/list";
		}
		
		@RequestMapping("/list/{id}")
		public Address findOne(@PathVariable Long id) {
			return addressService.findOne(id);	
		}
		
		@PostMapping("/add")
		public String addAddress(@ModelAttribute Address address,Model model) {
			String message="";
			if(address.getId()==null) {
				message="added";
			}else
			{
				message="updated";
			}
			model.addAttribute("message",addressService.addAddress(address).getUser().getUserName() + "address" + message + " added successfully ");
			return "message";	
		}
		
		@RequestMapping("/delete/{id}")
		public String deleteAddress(@PathVariable Long id,Model model) {
			model.addAttribute("message", addressService.deleteAddress(id));
			return "message";
		}
		


}
