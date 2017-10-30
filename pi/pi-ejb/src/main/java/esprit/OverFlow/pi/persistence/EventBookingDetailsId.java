package persistence;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable

@SuppressWarnings("serial")
public class EventBookingDetailsId implements Serializable {
private int eventId;
private int participantId;



public EventBookingDetailsId()
{
}
public EventBookingDetailsId(int eventId, int participantId) {
	super();
	this.eventId = eventId;
	this.participantId = participantId;
}
public int getEventId() {
	return eventId;
}
public void setEventId(int eventId) {
	this.eventId = eventId;
}
public int getParticipantId() {
	return participantId;
}
public void setParticipantId(int participantId) {
	this.participantId = participantId;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + eventId;
	result = prime * result + participantId;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	EventBookingDetailsId other = (EventBookingDetailsId) obj;
	if (eventId != other.eventId)
		return false;
	if (participantId != other.participantId)
		return false;
	return true;
}
}
