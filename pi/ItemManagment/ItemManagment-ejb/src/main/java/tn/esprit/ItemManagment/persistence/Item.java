package tn.esprit.ItemManagment.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Item
 *
 */
@Entity

public class Item implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String category;
	private double price;
	private String decription;
	private int quantity;
	private String picture;
	
	public Item(String name, String category, double price, String decription, int quantity) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.decription = decription;
		this.quantity = quantity;
	}
	

	public Item(String name, String category, double price, String decription, int quantity, String picture) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.decription = decription;
		this.quantity = quantity;
		this.picture = picture;
	}


	@OneToMany(mappedBy = "item")
	private List<Reservation> reservations;
	
	private static final long serialVersionUID = 1L;

	public Item() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}   
	public double getPrice() {
		return this.price;
	}
	public void setPrice(Double  price) {
		this.price = price;
	} 

	public void setDescription(String  description) {
		this.decription = description;
	}   
	public String getDescription() {
		return this.decription;
	}

	
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Name: "+ name+" Category:"+category ;
	}
	
	
	
	
   
}
