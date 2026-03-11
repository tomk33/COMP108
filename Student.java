public class Student {

    private String name = "";
    private String email;
    private int yearOfBirth;
    private int enrolmentYear;
    private int studentId;

    /**
     * Default constructor for creating an empty Student object.
     */
    public Student() {}

    /**
     * Constructor to initialize all student attributes.
     * @param studentName the student's name
     * @param studentEamil the student's email
     * @param studentDoB the student's birth year
     * @param studentYear the enrollment year
     * @param id the student's ID
     */
    public Student (String studentName, String studentEamil, int studentDoB, int studentYear, int id) {
        name = studentName;
        email = studentEamil;
        yearOfBirth = studentDoB;
        enrolmentYear = studentYear;
        studentId = id;
    }

    /**
     * Constructor to initialize name, email, and birth year.
     * @param studentName the student's name
     * @param studentEamil the student's email
     * @param studentDoB the student's birth year
     */
    public Student (String studentName, String studentEamil, int studentDoB) {
        name = studentName;
        email = studentEamil;
        yearOfBirth = studentDoB;
    }

    /**
     * Constructor to initialize student details using a String for birth date.
     * @param studentName the student's name
     * @param studentEamil the student's email
     * @param studentDoB the birth date string (e.g., "DD/MM/YYYY")
     */
    public Student (String studentName, String studentEamil, String studentDoB) {
        name = studentName;
        email = studentEamil;
        String[] splitDoB = studentDoB.split("[/]");
        yearOfBirth = Integer.parseInt(splitDoB[2]);
    }

    public boolean hasSubmitted = false;

    public int grade = 0;

    /**
     * Updates the student's grade with a new mark.
     * @param newGrade the new grade to assign
     */
    public void updateGrade(int newGrade) {
        if (!(newGrade <= 100 && newGrade >= 0)) {
            System.out.println("Enter a grade from 0-100.");
            return;
        }
        grade = newGrade;
        submitCoursework();
    }

    /**
     * Records that the student has submitted their coursework.
     */
    public void submitCoursework() {
        hasSubmitted = true;
    }

    /**
     * Getter Methods
     */
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getYearOfBirth() { return yearOfBirth; }
    public int getEnrolmentYear() { return enrolmentYear; }
    public int getStudentId() { return studentId; }
    public boolean getHasSubmitted() { return hasSubmitted; }
    public int getGrade() { return grade; }
}