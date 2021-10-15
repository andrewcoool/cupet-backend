package server;

public class UserCreatorRequestModel {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String homeAddress;
    private String password;

    public UserCreatorRequestModel(String firstName, String lastName, String email, String home, String pass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = email;
        this.homeAddress = home;
        this.password = pass;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmailAddress(){
        return this.emailAddress;
    }

    public String getHomeAddress(){
        return this.homeAddress;
    }

    public String getPassword(){
        return this.password;
    }

}