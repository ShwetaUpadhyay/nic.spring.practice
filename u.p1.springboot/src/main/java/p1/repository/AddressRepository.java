package p1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import p1.model.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{

}
