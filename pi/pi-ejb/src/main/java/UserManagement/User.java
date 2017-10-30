package persistence.UserManagement;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import persistence.AdoptionManagement.*;
import java.util.List;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class User implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String firstName;
	private String lastName;
	private String psw;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "agent", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<Animal> supervisedRooms;
	public User() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getPassword() {
		return this.psw;
	}

	public void setPassword(String password) {
		this.psw = password;
	}
   
}
