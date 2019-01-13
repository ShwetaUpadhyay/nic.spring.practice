package p1.service;

import java.util.List;

import p1.model.Address;

public interface AddressService {
	List<Address>addressList();
	Address findOne(Long id);
	Address addAddress(Address address);
	String deleteAddress(Long id);
}
