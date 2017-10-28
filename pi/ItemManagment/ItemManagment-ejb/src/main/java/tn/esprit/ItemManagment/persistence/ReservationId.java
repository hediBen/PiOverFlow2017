package tn.esprit.ItemManagment.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ReservationId
 *
 */
@Embeddable

public class ReservationId implements Serializable {

	
	private int idUser;
	private int idItem;
	//private Date DateResrv;
	private static final long serialVersionUID = 1L;

	public ReservationId() {
		super();
	}   
	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}   
	public int getIdItem() {
		return this.idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	} 

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idItem;
		result = prime * result + idUser;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationId other = (ReservationId) obj;
		if (idItem != other.idItem)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}
	public ReservationId(int idUser, int idItem) {
		super();
		this.idUser = idUser;
		this.idItem = idItem;
	}
   
}
