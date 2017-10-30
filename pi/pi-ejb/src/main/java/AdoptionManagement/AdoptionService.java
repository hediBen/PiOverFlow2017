package service.AdoptionManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.AdoptionManagement.AdoptionOffer;
import persistence.AdoptionManagement.Animal;

/**
 * Session Bean implementation class AdoptionService
 */
@Stateless
public class AdoptionService implements AdoptionServiceRemote, AdoptionServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public AdoptionService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addAdoptionOffer(Animal animal, AdoptionOffer adoptionOffer) {

		adoptionOffer.setAnimal(animal);

		entityManager.persist(adoptionOffer);
	}

	@Override
	public AdoptionOffer updateAnimal(AdoptionOffer a) {
		return entityManager.merge(a);
	}

	@Override
	public List<AdoptionOffer> getAllOffers() {
		String jpql = "SELECT u FROM AdoptionOffer u";
		Query q = entityManager.createQuery(jpql);
		return q.getResultList();
	}

	@Override
	public List<Animal> getAllOffersByType(String type) {
		return null;
	}

	@Override
	public AdoptionOffer findOfferById(int id) {
		return entityManager.find(AdoptionOffer.class, id);
	}

	@Override
	public void DeleteAdoptionOffer(AdoptionOffer adoptionOffer, int id) {
		entityManager.remove(findOfferById(id));

	}

	@Override
	public void addOffer(AdoptionOffer o) {
		entityManager.merge(o);
	}

}
