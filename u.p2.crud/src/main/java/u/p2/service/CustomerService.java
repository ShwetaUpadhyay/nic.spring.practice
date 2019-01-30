package u.p2.service;

import java.util.List;



import u.p2.model.Customer;

public interface CustomerService {
	public List<Customer>getCustomers();
	public void saveCustomer(Customer theCustomer);
	public Customer getCustomer(int theId);
	public void deleteCustomer(int theId);
	
}
