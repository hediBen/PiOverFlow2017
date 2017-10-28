package tn.esprit.ItemManagment.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.ItemManagment.persistence.Item;

@Local
public interface ItemServiceLocal {
	
	
	void addItem(Item item);
	
	void saveOrUpdate(Item item);

	
//	List<Item> findAllItemByCategory(String categoryItem);
	
	List<Item> findAllProducts();
	 Item findItemById(Integer idItem);
	 List<Item> findItemBYCategory(String name);
	
	void deleteItem(int itemId);
}
