package tn.esprit.ItemManagment.services;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import tn.esprit.ItemManagment.persistence.Item;

@Remote
@WebService
public interface ItemServiceRemote {
    @WebMethod(operationName="addItem")
    @WebResult(name="adding")
	void addItem(@WebParam(name="ItemObj") Item item);
	
    @WebMethod(operationName="saveOrUpdate")
    @WebResult( name="savingOrUpdating")
	void saveOrUpdate(@WebParam(name="ItemObj") Item item);
/*
    @WebMethod(operationName="findAllItemByCategory")
    @WebResult(name="ListItem")
	List<Item> findAllItemByCategory(@WebParam(name="categoryItem") String categoryItem);
	*/
    @WebMethod(operationName="findAllProducts")
    @WebResult(name="ListItem")
	List<Item> findAllProducts();
     List<Item> findItemBYCategory(String name);
    
    
    @WebMethod(operationName="findItemById")
    @WebResult(name="findingitems")
	public Item findItemById(@WebParam(name="idItem") Integer idItem);
	
    
    @WebMethod(operationName="deleteItem")
    @WebResult(name="deletingitems")
	void deleteItem(@WebParam(name="ItemId")int itemId);

}
