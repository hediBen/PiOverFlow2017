package service.AdoptionManagement;

import java.util.List;

import javax.ejb.Remote;

import persistence.AdoptionManagement.Animal;

@Remote
public interface AnimalServiceRemote {
	public void addAnimal(Animal a);

	public void deleteAnimal(int id);

	public Animal updateAnimal(Animal a);

	public Animal findAnimalById(int id);

	 List<Animal> getAllAnimals();
	
	public List<Animal> getAllAnimalsByType(String type);
	

}
