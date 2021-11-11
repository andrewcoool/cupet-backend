package server.controllers;

import server.use_cases.repo_abstracts.PetNotFoundException;

/**
 * An interface representing a connection to some implementation
 * of a back-end API.
 */
public interface APIGateway {

    /**
     * Create a new user and return a response in the form of a JSON string.
     *
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param homeAddress the user's home address
     * @param password the user's password
     * @param email the user's email
     */
    public String createUser(String firstName, String lastName,
                      String homeAddress, String password, String email);

    /**
     * Fetch a user by given user id.
     *
     * @param userId the user's id
     * @return A JSON structure of the user
     */
    public String fetchUserAccount(String userId);

    /**
     * Create a new pet.
     *
     * @param name the pet's name
     * @param age the pet's age
     * @param breed the pet's breed
     * @param biography the pet's biography
     * @return A JSON structure of the pet
     */
    public String createPet(String name, int age, String breed, String biography);

    /**
     * Fetch a pet by given pet id.
     *
     * @param petId the pet's id
     * @return A JSON structure of the pet
     */
    public String fetchPetProfile(String petId);

    /**
     * Edit a pet's information.
     *
     * @param petId the pet's id
     * @param newName the pet's new name
     * @param newAge the pet's new age
     * @param newBreed the pet's new breed
     * @param newBiography the pet's new biography
     * @return A JSON structure of the edited pet's information
     */
    public String editPet(String petId, String newName, int newAge, String newBreed, String newBiography);
}