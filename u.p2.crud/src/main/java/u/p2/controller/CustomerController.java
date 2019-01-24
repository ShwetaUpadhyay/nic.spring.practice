package u.p2.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import u.p2.model.Customer;
import u.p2.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		System.out.println("List called");
		List<Customer> theCustomer=customerService.getCustomers();
		model.addAttribute("customer", theCustomer);
		return "list-customers";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model model) {
		Customer theCustomer=new Customer();
		model.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("customerId")int theId,Model model) {
		Customer theCustomer=customerService.getCustomer(theId);
		model.addAttribute("customer", theCustomer);
		return "customer-form";	
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")int theId,Model model) {
		customerService.deleteCustomer(theId);
		return "redirect:/custome/list";
	}
	
}
