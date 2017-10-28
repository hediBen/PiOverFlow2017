package tn.esprit.ItemManagment.services;

import java.util.List;


import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.ItemManagment.persistence.Item;

/**
 * Session Bean implementation class ItemService
 */
@Stateless
@WebService(name="ItemServicePortype",
			portName="ItemService",
			serviceName="ItemService",
			targetNamespace="http://ItemServicePi.tn",endpointInterface="tn.esprit.ItemManagment.services.ItemServiceRemote"
			)

public class ItemService implements ItemServiceRemote, ItemServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public ItemService() {
    	
    }
    

	@Override
	public void addItem(Item item) {
		entityManager.persist(item);		
	}

	@Override
	public void saveOrUpdate(Item item) {
		entityManager.merge(item);

	}

	
	@Override
	public List<Item> findAllProducts() {
		//return entityManager.createQuery("SELECT i FROM Item i", Item.class).getResultList();
		
		String jpql = "SELECT i FROM Item i";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList() ;
	}

	@Override
	public void deleteItem(int itemId) {
		entityManager.remove(findItemById(itemId));

		
	}
    
  
	@Override
	public Item findItemById(Integer idItem) {
		return entityManager.find(Item.class, idItem);
	}
	
	
	@Override
	public  List<Item> findItemBYCategory(String name) {
		String jpql = "SELECT e FROM Item e WHERE e.category like :param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", "%"+name+"%");
		return query.getResultList();
	}

}
