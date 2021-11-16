package server.entities;

public abstract class Pet {

    private int userId;
    private String name;
    private int age;
    private String biography;
    private String breed;
    private int id;

    public Pet(int userId, String name, int age, String breed, String biography) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.biography = biography;
        this.breed = breed;
    }

    public boolean isNameValid() {
        return this.name.trim().length() >= 3;
    }

    public boolean isAgeValid() {
        return this.age >= 0;
    }

    public boolean isBreedValid() {
        return this.breed.trim().length() >= 3;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getBiography() {
        return this.biography;
    }

    public String getBreed() {
        return this.breed;
    };

    public int getId() {
        return id;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Pet)) {
            return false;
        }

        return ((Pet) other).getId() == this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}