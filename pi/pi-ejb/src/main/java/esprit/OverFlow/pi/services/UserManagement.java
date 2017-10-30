package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import persistence.Member;
import persistence.User;

/**
 * Session Bean implementation class UserManagement
 */
@Stateless
@WebService(name = "userPortype", portName = "userPort", serviceName = "userService",
targetNamespace = "http://user.tn",endpointInterface="services.UserManagementRemote")public class UserManagement implements UserManagementRemote, UserManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserManagement() {
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);

	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public void deleteUserById(int id) {
		entityManager.remove(findUserById(id));
	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
	//merge() should be used to attach the detached entity
	}

	@Override
	public User findUserById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> findAllUsers() {
		String jpql = "SELECT u FROM User u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public User findUserByLogin(String login) {
		 String jpql="select u FROM User u where u.username =:l";
	        System.out.println(jpql);
			Query query = entityManager.createQuery(jpql);
			query.setParameter("l", login);
			return (User) query.getSingleResult();

	}
	@Override
	public User findUserByMail(String mail) {
		 String jpql="select u FROM User u where u.mail =:l";
	        System.out.println(jpql);
			Query query = entityManager.createQuery(jpql);
			query.setParameter("l", mail);
			return (User) query.getSingleResult();

	}
	@Override
	public User login(String login,String pwd) {
        
		String jpql="select u FROM User u where u.username=:l and u.psw=:p";
		
		System.out.println(jpql);
		Query query = entityManager.createQuery(jpql);
		query.setParameter("l", login).setParameter("p", pwd);
		return(User) query.getSingleResult();
		
		    }
	@Override
	public int UsernameExists(String login) {
		 String jpql="select u FROM User u where u.username =:l";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("l", login);
		return query.getResultList().size();
		
	}
	@Override
	public int EmailExists(String mail) {
		 String jpql="select u FROM User u where u.mail =:l";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("l", mail);
		return query.getResultList().size();
		
	}
	@Override
	public Member findMemberById(int id) {
		return entityManager.find(Member.class, id);
	}
	@Override
	public Member fideliser(Member m,int pts) {
		
		m.addPoints(pts);
		if(m.getPoints()==100) {
		m.setReductNextTimePercent(10);
		m.setPoints(0);
		}
		if (m.getReductNextTimePercent()==10) {
			m.setReductNextTimePercent(0);
		}
		System.out.println("user fidelise"+m.toString());
//		User u=new User();
//		 u=findUserById(m.getId());
//		 System.out.println("user fidelise"+u.toString());
//		//m=(Member) findUserById(m.getId());
//		updateUser(u);
		entityManager.merge(m);
		return m;
	}

}
