package tn.esprit.ItemManagment.services;

import javax.ejb.Remote;

import tn.esprit.ItemManagment.persistence.User;

@Remote
public interface UserServiceRemote {
	void addUser(User user);

	User findUserById(Integer idUser);

	void updateUser(User user);

	User login(String login, String password);

}
