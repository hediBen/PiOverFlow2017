package tn.esprit.ItemManagment.services;

import javax.ejb.Local;

import tn.esprit.ItemManagment.persistence.User;

@Local
public interface UserServiceLocal {
	void addUser(User user);

	User findUserById(Integer idUser);

	void updateUser(User user);

	User login(String login, String password);

}
