package inheritanceLab;

public class Student extends Person {
      private int grade;

      /** 
       * Sets new grade
       * @param new_grade
       */
      public void setGrade(int newGrade) {
          grade = newGrade;
      }

      /** 
       * Returns grade
       * @return int
       */
      public int getGrade() {
          return grade;
      }
  }
  