package inheritanceLab;

public class Professor extends Lecturer {
    private int budget;

    /** 
     * Returns budget
     * @return int
     */
    public int getBudget() {
        return budget;
    }

    /** 
     * Sets new budget
     * @param newBudget
     */
    public void setBudget(int newBudget) {
        budget = newBudget;
    }
}
