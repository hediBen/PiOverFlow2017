package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Agent;
import persistence.Event;
import persistence.EventBookingDetails;
import persistence.Member;
import persistence.User;

/**
 * Session Bean implementation class BasicOps
 */
@Stateless
@LocalBean
public class BasicOps {

	@PersistenceContext
	private EntityManager entityManager;
	
    public BasicOps() {
        // TODO Auto-generated constructor stub
    }
	public void saveOrUpdateMember(Member obj) {
		entityManager.merge(obj);
	}
	public void saveOrUpdateAgent(Agent obj) {
		entityManager.merge(obj);
	}
	public void saveOrUpdateEvent(Event obj) {
		entityManager.merge(obj);
	}
	public void saveOrUpdateEventBooking(EventBookingDetails obj) {
		entityManager.merge(obj);
	}
	public User findUserByLogin(String login) {
		 String jpql="select u FROM User u where u.username =:l";
	        System.out.println(jpql);
			Query query = entityManager.createQuery(jpql);
			query.setParameter("l", login);
			return (User) query.getSingleResult();

	}
	
}
