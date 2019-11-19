import org.json.JSONObject;

public class Human implements IParsable, ICSVParsable, IJSONParsable {
    private String id;
    private String email;
    private String birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private String city;
    private String state;


    public String getState() {
        return state;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public void initialize(String[] map) {
        this.id = map[0];
        this.email = map[1];
        this.birthDate = map[2];
        this.firstName = map[3];
        this.lastName = map[4];
        this.gender = map[5];
        this.city = map[6];
        this.state = map[7];
    }

    @Override
    public String toString() {
        return (id + " " + email + " " + birthDate + " " + firstName + " " + lastName + " " + gender + " " + city + " " + state);
    }

    @Override
    public String[] fromCSV(String line) {
        return line.split(";");
    }

    @Override
    public String[] fromJson(String line) {
        JSONObject jsonObject = new JSONObject(line);
        String[] arr = new String[8];
        arr[0] = jsonObject.getString("guid");
        arr[1] = jsonObject.getString("email");
        arr[2] = jsonObject.getString("birthday");
        arr[3] = jsonObject.getString("first");
        arr[4] = jsonObject.getString("last");
        arr[5] = jsonObject.getString("gender");
        arr[6] = jsonObject.getString("city");
        arr[7] = jsonObject.getString("state");
        return arr;
    }
}
