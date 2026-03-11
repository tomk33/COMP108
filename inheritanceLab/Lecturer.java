package inheritanceLab;

public class Lecturer extends Person {
    private String timetable;

    /** 
     * Returns timetable
     * @return String
     */
    public String getTimeTable() {
        return timetable;
    }

    /** 
     * Sets new timetable
     * @param newTimetable
     */
    public void setTimeTable(String newTimetable) {
        timetable = newTimetable;
    }
}
