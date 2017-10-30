package service.AdoptionManagement;

import java.util.List;

import javax.ejb.Local;

import persistence.AdoptionManagement.AdoptionOffer;
import persistence.AdoptionManagement.Animal;

@Local
public interface AdoptionServiceLocal {
void addAdoptionOffer(Animal animal, AdoptionOffer adoptionOffer) ;
	void DeleteAdoptionOffer(AdoptionOffer adoptionOffer, int id);
	public AdoptionOffer updateAnimal(AdoptionOffer a);
	
	List<AdoptionOffer> getAllOffers();
	
	 List<Animal> getAllOffersByType(String type);
	 AdoptionOffer findOfferById(int id);
	 void addOffer(AdoptionOffer o) ;

}
