public class ResearchCouncil implements Emailable, Billable {
    private String name;
    private String email;

    public void payBill(int amount) {
        System.out.println(amount);
    }

    public void sendEmail() {
        System.out.println("sendto: " + email + "Hi " + name + ",\n");
    }
}
