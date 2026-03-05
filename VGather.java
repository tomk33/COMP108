public class VGather {
    public static void main(String[] args) {
        System.out.println("How Many Students In Class?");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());

        Student[] studentArray = new Student[students];

        for (int i=0; i<=students; i++) {
            System.out.println("Enter a grade");
            java.util.Scanner scanner1 = new java.util.Scanner(System.in);
            int inputGrade = Integer.parseInt(scanner1.nextLine());
            studentArray[i].updateGrade(inputGrade);
        }

        int gradeSum = 0;

        for (int j=0; j<students; j++) {
            gradeSum += studentArray[j].grade;
        }

        double average = Math.round((gradeSum/students)*100)/100;
        System.out.println(average);
    }
}
