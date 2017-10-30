package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Event;

/**
 * Session Bean implementation class EventManagement
 */
@Stateless

@WebService(name = "eventPortype", portName = "eventPort", serviceName = "eventService",
targetNamespace = "http://event.tn",endpointInterface="services.EventManagementRemote")
public class EventManagement implements EventManagementRemote, EventManagementLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public EventManagement() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void addEvent(Event e) {
		System.out.println(e.toString());
		entityManager.persist(e);
	}

	
	@Override
	public void updateEvent(Event e) {
		entityManager.merge(e);

	}

	@Override
	public void deleteEventById(int id) {
		entityManager.remove(findEventById(id));

	}

	
	@Override
	public void deleteEvent(Event e) {
		entityManager.remove(e);
		System.out.println("event deleted");

	}

	
	@Override
	public Event findEventById(int id) {
		return entityManager.find(Event.class, id);
	}

	
	@Override
	public List<Event> findAllEvents() {
		String jpql = "SELECT u FROM Event u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public  List<Event> findEventBy(String search) {
		String jpql = "SELECT e FROM Event e WHERE e.category like :param or e.name like :param or e.location like :param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", "%"+search+"%");
		return query.getResultList();
	}
	
}
