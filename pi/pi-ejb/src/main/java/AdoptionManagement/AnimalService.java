package service.AdoptionManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.AdoptionManagement.Animal;

/**
 * Session Bean implementation class AnimalService
 */
@Stateless

public class AnimalService implements AnimalServiceRemote, AnimalServiceLocal {

	@PersistenceContext
	private EntityManager entityManager;

	public AnimalService() {
	}

	@Override
	public void addAnimal(Animal animal) {
		entityManager.persist(animal);
	}

	@Override
	public void deleteAnimal(int id) {
		entityManager.remove(findAnimalById(id));
	}

	@Override
	public Animal updateAnimal(Animal a) {
		return entityManager.merge(a);
	}

	@Override
	public Animal findAnimalById(int id) {
		return entityManager.find(Animal.class, id);

	}

	@Override
	public List<Animal> getAllAnimals() {

		String jpql = "SELECT u FROM Animal u";
		Query q = entityManager.createQuery(jpql);
		return q.getResultList();

	}

	@Override
	public List<Animal> getAllAnimalsByType(String type) {
		String jpql = "SELECT e FROM Animal e WHERE e.type =:param";
		Query QUERY = entityManager.createQuery(jpql);
		QUERY.setParameter("param", type);
		return QUERY.getResultList();
	}

}
