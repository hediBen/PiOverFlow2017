package esprit.OverFlow.pi.services;

import java.util.List;

import javax.ejb.Local;

import esprit.OverFlow.pi.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
