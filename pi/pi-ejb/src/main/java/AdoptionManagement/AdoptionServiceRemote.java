package service.AdoptionManagement;

import java.util.List;

import javax.ejb.Remote;

import persistence.AdoptionManagement.AdoptionOffer;
import persistence.AdoptionManagement.Animal;

@Remote
public interface AdoptionServiceRemote {
	
	
	void addAdoptionOffer(Animal animal, AdoptionOffer adoptionOffer);
	
	void DeleteAdoptionOffer(AdoptionOffer adoptionOffer, int id);
	public AdoptionOffer updateAnimal(AdoptionOffer a);
	
	List<AdoptionOffer> getAllOffers();
	
	 List<Animal> getAllOffersByType(String type);
	 AdoptionOffer findOfferById(int id);
	 void addOffer(AdoptionOffer o) ;
	
}
