import java.util.Comparator;

public class Human {
    private String id;
    private String email;
    private String birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private String city;
    private String state;

    Human(String str) {
        String[] lines = str.split(";");
        this.id = lines[0];
        this.email = lines[1];
        this.birthDate = lines[2];
        this.firstName = lines[3];
        this.lastName = lines[4];
        this.gender = lines[5];
        this.city = lines[6];
        this.state = lines[7];
    }

    public String getState() {
        return state;
    }

    public String toString() {
        return (id + " " + email + " " + birthDate + " " + firstName + " " + lastName + " " + gender + " " + city + " " + state);
    }
}
