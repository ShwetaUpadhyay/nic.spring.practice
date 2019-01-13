package p1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import p1.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
