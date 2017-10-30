package services;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import persistence.Event;

@Remote
@WebService(targetNamespace = "http://event.tn")

public interface EventManagementRemote {
	
	@WebMethod(operationName = "addEventOperation")
	@WebResult(name = "addEventResult")
	void addEvent(@WebParam(name="event")Event e);
	
	@WebMethod(operationName = "updateEventOperation")
	@WebResult(name = "updateEventResult")
	void updateEvent(@WebParam(name="event") Event e);

	@WebMethod(operationName = "deleteEventByIdOperation")
	@WebResult(name = "deleteEventByIdResult")
	void deleteEventById(@WebParam(name="idEvent")int id);
	
	@WebMethod(operationName = "deleteEventOperation")
	@WebResult(name = "deleteEventResult")
	void deleteEvent(@WebParam(name="event") Event e);

	@WebMethod(operationName = "findEventByIdOperation")
	@WebResult(name = "findEventByIdResult")
	Event findEventById(@WebParam(name="idEvent") int id);

	@WebMethod(operationName = "findAllEventsOperation")
	@WebResult(name = "findAllEventsResult")
	List<Event> findAllEvents();
	
	@WebMethod(operationName = "findEventByOperation")
	@WebResult(name = "findEventByResult")
	List<Event> findEventBy(String search);

}
