package persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: EventBookingDetails
 *
 */
@Entity
public class EventBookingDetails implements Serializable {
	@EmbeddedId
	private EventBookingDetailsId eventBookingDetailsId;
	private int nbPlaces;
	private int code;
	@Enumerated(EnumType.STRING)
	private TypeOfFees fees;
	

	@ManyToOne
	@JoinColumn(name = "participantId", referencedColumnName = "id", insertable = false, updatable = false)
	private User participant;

	@ManyToOne
	@JoinColumn(name = "eventId", referencedColumnName = "id", insertable = false, updatable = false)
	private Event event;
	private static final long serialVersionUID = 1L;

	public EventBookingDetails() {
		super();
	}

	public EventBookingDetails(int nbPlaces, User participant,Event event,TypeOfFees fees) {
		super();
		this.eventBookingDetailsId = new EventBookingDetailsId(event.getId(), participant.getId());
		this.nbPlaces = nbPlaces;
		this.code = eventBookingDetailsId.hashCode();
		this.participant = participant;
		this.event = event;
		this.fees=fees;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public User getParticipant() {
		return participant;
	}

	public void setParticipant(User participant) {
		this.participant = participant;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	public TypeOfFees getFees() {
		return fees;
	}

	public void setFees(TypeOfFees fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "EventBookingDetails [eventBookingDetailsId=" + eventBookingDetailsId + ", nbPlaces=" + nbPlaces
				+ ", code=" + code + ", fees=" + fees + ", participant=" + participant + ", event=" + event + "]";
	}


	

}
