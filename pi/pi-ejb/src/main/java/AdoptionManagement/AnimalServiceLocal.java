package service.AdoptionManagement;

import java.util.List;

import javax.ejb.Local;

import persistence.AdoptionManagement.Animal;

@Local
public interface AnimalServiceLocal {

	public void addAnimal(Animal a);

	public void deleteAnimal(int id);

	public Animal updateAnimal(Animal a);

	public Animal findAnimalById(int id);

	public List<Animal> getAllAnimals();
	public List<Animal> getAllAnimalsByType(String type);
	
}
