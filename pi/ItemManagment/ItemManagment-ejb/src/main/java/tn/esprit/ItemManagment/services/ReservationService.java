package tn.esprit.ItemManagment.services;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.ItemManagment.persistence.Item;
import tn.esprit.ItemManagment.persistence.Member;
import tn.esprit.ItemManagment.persistence.Reservation;
import tn.esprit.ItemManagment.persistence.User;

/**
 * Session Bean implementation class ReservationService
 */
@Stateless
@WebService(name="ReservationServicePortype",
portName="ReservationService",
serviceName="ReservationService",
targetNamespace="http://ReservationServicePi.tn",endpointInterface="tn.esprit.ItemManagment.services.ReservationServiceRemote"
)
public class ReservationService implements ReservationServiceRemote, ReservationServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private UserServiceLocal userServicesLocal;
	@EJB
	private ItemServiceLocal itemServicesLocal;
    /**
     * Default constructor. 
     */
    public ReservationService() {
        
    }
    

	@Override
	public void purchase(Integer idCustomer, Integer idProduct, Integer quantity,double totalPrice) {
		
		Member member = (Member) userServicesLocal.findUserById(idCustomer);
		
		Item item = itemServicesLocal.findItemById(idProduct);
		totalPrice=quantity*item.getPrice();
		
		if (item.getQuantity() >= (quantity)) {
			Reservation reservation = new Reservation(quantity,totalPrice, member, item);
			
			item.setQuantity(item.getQuantity() -quantity);

			
			entityManager.merge(reservation);
			//entityManager.merge(member);
		} else {
			Reservation reservation = new Reservation(quantity,totalPrice, member, item);
			entityManager.merge(reservation);
		}
		
	}


	@Override
	public List<Reservation> findAllResv() {
				String jpql = "SELECT r FROM Reservation r";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList() ;
	}
	
	
	
	
	
	@Override
	public List<Reservation> findReservationByMember(int user) {

		String jpql="SELECT r FROM Reservation r join  r.memeber m where m.id = :param ";
				
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", user);
		return query.getResultList();
	
	}
   

}
