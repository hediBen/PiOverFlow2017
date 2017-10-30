package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Agent
 *
 */
@Entity
@DiscriminatorValue(value="agent")

public class Agent extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	public Agent(String username, String mail, String psw, String firstname, String lastname, Date birthday,
			String phone) {
		super(username, mail, psw, firstname, lastname,birthday,phone);
		//this.address=address;
	}

	public Agent() {
		// TODO Auto-generated constructor stub
	}

}
