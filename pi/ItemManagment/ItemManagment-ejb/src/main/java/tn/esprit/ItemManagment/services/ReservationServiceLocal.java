package tn.esprit.ItemManagment.services;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import tn.esprit.ItemManagment.persistence.Item;
import tn.esprit.ItemManagment.persistence.Member;
import tn.esprit.ItemManagment.persistence.Reservation;
import tn.esprit.ItemManagment.persistence.User;

@Local
public interface ReservationServiceLocal {
	void purchase(Integer idCustomer, Integer idProduct, Integer quantity,double totalPrice);
	//Boolean createTransaction(Integer customerId, Integer productId,
		//	double price, Integer quantity);
	// List<Reservation> findAllReservationsByIdUser(int idUser);
	List<Reservation> findAllResv();
	List<Reservation> findReservationByMember(int user);
}
