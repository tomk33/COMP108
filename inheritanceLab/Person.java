package inheritanceLab;

public class Person {
    private String name;
    private String email;

    /** 
     * Returns greeting message
     * @return String
     */
    public String greet() {
        return "sendto: " + email + "Hi " + name + ",\n";
    }

    /** 
     * Sets new name
     * @param newName
     */
    public void setName(String newName) {
        name = newName;
    }

    /** 
     * Returns name
     * @return String
     */
    public String getName() {
        return name;
    }

    /** 
     * Sets new email
     * @param newEmail
     */
    public void setEmail(String newEmail) {
        email = newEmail;
    }

    /** 
     * Returns email
     * @return String
     */
    public String getEmail() {
        return email;
    }
}
