package persistence.UserManagement;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import persistence.UserManagement.User;

/**
 * Entity implementation class for Entity: Member
 *
 */
@Entity
@DiscriminatorValue(value="member")

public class Member extends User implements Serializable {

	
	private String adresse;
	private static final long serialVersionUID = 1L;

	public Member() {
		super();
	}   
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
   
}
