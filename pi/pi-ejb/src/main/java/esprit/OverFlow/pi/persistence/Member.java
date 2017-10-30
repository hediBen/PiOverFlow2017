package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Member
 *
 */
@Entity
@DiscriminatorValue(value="member")
public class Member extends User implements Serializable {
	
	private int points=0;
	private boolean isBanned=false;
	private int reductNextTimePercent=0;
	
	private static final long serialVersionUID = 1L;

	public Member(String username, String mail, String psw, String firstname, String lastname, Date birthday,
			String phone) {
		super(username, mail, psw, firstname, lastname,birthday,phone);
		this.points=0;
		this.isBanned=false;
		this.reductNextTimePercent=0;
	}
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	public void addPoints(int points) {
		this.points += points;
	}
	public boolean isBanned() {
		return isBanned;
	}

	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}

	public int getReductNextTimePercent() {
		return reductNextTimePercent;
	}

	public void setReductNextTimePercent(int reductNextTimePercent) {
		this.reductNextTimePercent = reductNextTimePercent;
	}
	@Override
	public String toString() {
		return "Member [points=" + points + ", isBanned=" + isBanned + ", reductNextTimePercent="
				+ reductNextTimePercent + ", id=" + id + ", username=" + username + ", mail=" + mail + ", psw=" + psw
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", birthday=" + birthday + ", phone=" + phone
				+ "]";
	}





	

}
