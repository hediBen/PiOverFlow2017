package tn.esprit.ItemManagment.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.ItemManagment.persistence.User;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService implements UserServiceRemote, UserServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public UserService() {
    }

	@Override
	public void addUser(User user) {
		entityManager.persist(user);		
	}

	@Override
	public User findUserById(Integer idUser) {
		return entityManager.find(User.class, idUser);
	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);		
	}

	@Override
	public User login(String login, String password) {
		User user = null;
		String jpql = "SELECT u FROM User u WHERE u.login = :param1 AND u.password = :param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("user not found");
		}
		return user;		
	}

}
