package p1.model;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Getter;
import lombok.Setter;

@Entity
public class User extends AbstractPersistable<Long> {
	
	private @Getter @Setter String userName;
	private @Getter @Setter String UserId;
	private @Getter @Setter String password;
	private @Getter @Setter transient Long id;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private @Getter @Setter Role role;
	
	@OneToMany(targetEntity=Address.class,mappedBy="user",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Address>addresses;

}
