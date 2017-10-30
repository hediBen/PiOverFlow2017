package persistence.UserManagement;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import persistence.UserManagement.User;

/**
 * Entity implementation class for Entity: Moderator
 *
 */
@Entity

public class Moderator extends User implements Serializable {

	
	private String sector;
	private static final long serialVersionUID = 1L;

	public Moderator() {
		super();
	}   
	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}
   
}
