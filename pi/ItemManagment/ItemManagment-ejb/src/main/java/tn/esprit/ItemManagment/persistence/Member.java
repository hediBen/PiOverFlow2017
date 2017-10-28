package tn.esprit.ItemManagment.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Member
 *
 */
@Entity

public class Member extends User implements Serializable {

	
	private int points;
	private boolean isBanned;
	private static final long serialVersionUID = 1L;

	public Member() {
		super();
	}   
	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}   
	public boolean getIsBanned() {
		return this.isBanned;
	}

	public void setIsBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}
	@Override
	public String toString() {
		return ""+ points;
	}

	
   
}
