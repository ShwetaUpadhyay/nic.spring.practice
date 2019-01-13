package p1.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import p1.model.Address;
import p1.repository.*;
import p1.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
	private AddressRepository addressRepository;
	private UserRepository userRepository;
	
	@Autowired
	public AddressServiceImpl(AddressRepository addressRepository,UserRepository userRepository) {
		this.addressRepository = addressRepository;
		this.userRepository=userRepository;
	}

	@Override
	public List<Address> addressList() {
		return addressRepository.findAll();
	}

	@Override
	public Address findOne(Long id) {
		return addressRepository.findById(id).get();
	}

	@Override
	public Address addAddress(Address address) {
		address.setUser(userRepository.getOne(address.getUser().getId()));
		return addressRepository.save(address);
	}

	@Override
	public String deleteAddress(Long id) {
		addressRepository.deleteById(id);
		return "address deleted successfully";
	}
}
