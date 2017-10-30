package services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Event;
import persistence.EventBookingDetails;
import persistence.Member;
import persistence.TypeOfFees;
import persistence.User;

/**
 * Session Bean implementation class BookingService
 */
@Stateless
public class BookingService implements BookingServiceRemote {
	@PersistenceContext
	private EntityManager entityManager;


	@EJB
	private UserManagementLocal userManagementLocal;

	@EJB
	private EventManagementLocal eventManagementLocal;
	/**
	 * Default constructor.
	 */
	public BookingService() {
	}



	@Override
	public void ParticipateEvent(Event e, User u, int nbPlaces, TypeOfFees fees) {
		if (fees==fees.Bench) e.setBenchNb(e.getBenchNb()-nbPlaces);
		else if (fees==fees.Chair) e.setChairsNb(e.getChairsNb()-nbPlaces);
		else e.setVipNb(e.getVipNb()-nbPlaces);
		EventBookingDetails bookinkDetails = new EventBookingDetails(nbPlaces,u,entityManager.merge(e),fees);		
		entityManager.persist(bookinkDetails);		
	}
	@Override
	public List<EventBookingDetails> findEventsByMemberId(int idMember) {
		String jpql="SELECT b FROM EventBookingDetails b  where b.participant.id= :param  ";
		//String jpql="SELECT b FROM EventBookingDetails b join b.event p where p.id=e.id  and b.participant.id= :param  ";
		System.out.println(jpql);
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", idMember);
		return query.getResultList();
		
	}
	@Override
	public List<Member> findMostActiveMembers() {
		
		List<User> members = userManagementLocal.findAllUsers();
		Member theOne = new Member();
		List<Member> membersElected = new ArrayList<>();
		for (User u : members) {
			if (u instanceof Member && u != null) {
				try {
					int sizeOf = findEventsByMemberId(u.getId()).size();
					int theOneSize =findEventsByMemberId(theOne.getId()).size();
					if (sizeOf == theOneSize) {
						theOne = (Member) u;
						membersElected.add(theOne);
					}
					if (sizeOf > theOneSize) {
						theOne = (Member) u;
						membersElected = new ArrayList<>();
						membersElected.add(theOne);
					}

				} catch (Exception e) {
					System.out.println("the one is NULL");
				}

			} else {
				System.out.println("not a member");
			}
		}
		return membersElected;
	}

}
