package tn.esprit.ItemManagment.services;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import tn.esprit.ItemManagment.persistence.Item;
import tn.esprit.ItemManagment.persistence.Member;
import tn.esprit.ItemManagment.persistence.Reservation;
import tn.esprit.ItemManagment.persistence.User;
@WebService
@Remote
public interface ReservationServiceRemote {
    @WebMethod(operationName="Purchase")
    @WebResult(name="adding")
	void purchase(@WebParam(name="idCustomer") Integer idCustomer,@WebParam(name="idProduct") Integer idProduct,@WebParam(name="quantity") Integer quantity,@WebParam(name="totalPrice")double totalPrice);
	
    //List<Reservation> findAllReservationsByIdUser(int idUser);
    List<Reservation> findAllResv();
    List<Reservation> findReservationByMember(int user);
}
