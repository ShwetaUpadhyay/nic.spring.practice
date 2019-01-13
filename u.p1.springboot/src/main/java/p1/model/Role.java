package p1.model;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Role extends AbstractPersistable<Long>{
	private @Getter @Setter String name;
	private @Getter @Setter transient Long id;
	
	@OneToMany(targetEntity=User.class,mappedBy="role",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<User> users;
}
