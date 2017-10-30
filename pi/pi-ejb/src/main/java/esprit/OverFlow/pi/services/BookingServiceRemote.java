package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Event;
import persistence.EventBookingDetails;
import persistence.Member;
import persistence.TypeOfFees;
import persistence.User;

@Remote
public interface BookingServiceRemote {


	void ParticipateEvent(Event e, User u, int nbPlaces, TypeOfFees fees);
	List<Member> findMostActiveMembers();
	List<EventBookingDetails> findEventsByMemberId(int idMember);
}
