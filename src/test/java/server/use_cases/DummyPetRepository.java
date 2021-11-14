package server.use_cases;

import server.entities.Pet;
import server.use_cases.repo_abstracts.IPetRepository;
import server.use_cases.repo_abstracts.PetNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * A dummy class representing a pet entity in the repository
 */
class DummyPetRepositoryEntity {

    private int id, userId;
    private String name;
    private int age;
    private String breed;
    private String biography;
    private List<Integer> swipedOn, matches;

    public DummyPetRepositoryEntity(int id, int userId, String name, int age, String breed, String biography) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.biography = biography;
        this.swipedOn = new ArrayList<>();
        this.matches = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public String getBiography() {
        return biography;
    }

    public List<Integer> getSwipedOn() {
        return this.swipedOn;
    }

    public List<Integer> getMatches() {
        return this.matches;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
/**
 * A dummy pet repository that stores users in memory.
 */
public class DummyPetRepository implements IPetRepository {
    private final ArrayList<DummyPetRepositoryEntity> pets;
    private int currentMaxId;

    public DummyPetRepository() {
        pets = new ArrayList<>();
        currentMaxId = -1;
    }

    /**
     * Create a new pet and save it in the repository.
     *
     * @param userId    the user id of the pet's owner;
     * @param name      the pet's name;
     * @param age       the Pet's age;
     * @param breed     the Pet's breed;
     * @param biography the Pet's biography;
     * @return new pet's id;
     */
    @Override
    public int createPet(int userId, String name, int age, String breed, String biography) {
        currentMaxId++;
        int petId = currentMaxId;
        pets.add(new DummyPetRepositoryEntity(petId, userId, name, age, breed, biography));
        return petId;
    }

    /**
     * Fetch a pet's by a given pet id.
     *
     * @param petId the pet's id;
     * @return Pet;
     * @throws PetNotFoundException ;
     */
    @Override
    public Pet fetchPet(int petId) throws PetNotFoundException {
        DummyPetRepositoryEntity dbPet = pets.stream().filter(pet -> pet.getId() == petId).findFirst().orElse(null);

        if (petId >= 0 && petId <= currentMaxId && dbPet != null) {
            Pet pet = new Pet(dbPet.getUserId(), dbPet.getName(), dbPet.getAge(), dbPet.getBreed(), dbPet.getBiography()) {};
            pet.getSwipedOn().addAll(dbPet.getSwipedOn());
            pet.getMatches().addAll(dbPet.getMatches());
            return pet;
        } else {
            throw new PetNotFoundException("Pet with ID: " + petId + " not found.");
        }
    }

    /**
     * Edit a pet's information, given all new information.
     *
     * @param petId        the pet's id;
     * @param newName      the pet's new name;
     * @param newAge       the pet's new age;
     * @param newBreed     the pet's new breed;
     * @param newBiography the pet's new biography;
     * @return if the editing is successfully done;
     */
    @Override
    public boolean editPet(int petId, String newName, int newAge, String newBreed, String newBiography) {
        DummyPetRepositoryEntity dbPet = pets.stream().filter(pet -> pet.getId() == petId).findFirst().orElse(null);

        if (petId >= 0 && petId <= currentMaxId && dbPet != null) {
            dbPet.setName(newName);
            dbPet.setAge(newAge);
            dbPet.setBreed(newBreed);
            dbPet.setBiography(newBiography);
            return true;
        } else return false;
    }

}
