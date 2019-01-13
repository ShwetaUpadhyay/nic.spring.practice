package p1.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Address extends AbstractPersistable<Long>{
	private @Getter @Setter String State;
	private @Getter @Setter String Country;
	private @Getter @Setter String City;
	private @Getter @Setter transient Long id;
	private @Getter @Setter transient Long userId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private @Getter @Setter User user;
}
