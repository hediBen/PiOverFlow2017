package services;

import java.util.List;

import javax.ejb.Local;

import persistence.Event;

@Local
public interface EventManagementLocal {
	void addEvent(Event e);

	void updateEvent(Event e);

	void deleteEventById(int id);

	void deleteEvent(Event e);

	Event findEventById(int id);

	List<Event> findAllEvents();
	List<Event> findEventBy(String search);
}
