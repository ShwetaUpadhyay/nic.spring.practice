package u.p2.DAO;

import java.util.List;


import u.p2.model.Customer;

public interface CustomerDAO {
	public List<Customer>getCustomers();
	public void saveCustomer(Customer theCustomer);
	public Customer getCustomer(int theId);
	public void deleteCustomer(int theId);
}
