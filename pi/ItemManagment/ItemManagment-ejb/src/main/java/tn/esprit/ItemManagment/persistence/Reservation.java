package tn.esprit.ItemManagment.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reservation
 *
 */
@Entity

public class Reservation implements Serializable {

	@EmbeddedId
	private ReservationId reservationId;
	private int quantity;
	private double totalPrice;
	
	
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", updatable = false, insertable = false)
	private User memeber;
	@ManyToOne
	@JoinColumn(name = "idItem", referencedColumnName = "id", updatable = false, insertable = false)
	private Item item;
	
	
	public Reservation(int quantity, double totalPrice, User memeber, Item item) {
		super();
		this.reservationId = new ReservationId(memeber.getId(), item.getId());
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.memeber = memeber;
		this.item = item;
	}

	private static final long serialVersionUID = 1L;

	public Reservation() {
		super();
	}   
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}   
	public double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public ReservationId getReservationId() {
		return reservationId;
	}
	public void setReservationId(ReservationId reservationId) {
		this.reservationId = reservationId;
	}
	public User getMemeber() {
		return memeber;
	}
	public void setMember(User memeber) {
		this.memeber = memeber;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public void setMemeber(User memeber) {
		this.memeber = memeber;
	}
	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", quantity=" + quantity + ", totalPrice=" + totalPrice
				+ ", memeber=" + memeber + ", item=" + item + "]";
	}
	
   
}
