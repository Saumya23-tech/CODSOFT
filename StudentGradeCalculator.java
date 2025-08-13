import java.util.Scanner;

public class StudentGradeCalculator {

    public static String getGrade(double percentage) {
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else return "F";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== STUDENT GRADE CALCULATOR =====\n");

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        if (subjects <= 0) {
            System.out.println("❌ Invalid number of subjects!");
            return;
        }

        double totalMarks = 0;

        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks for Subject " + i + " (out of 100): ");
            double marks = sc.nextDouble();

            if (marks < 0 || marks > 100) {
                System.out.println("❌ Invalid marks! Enter between 0 and 100.");
                return;
            }
            totalMarks += marks;
        }

        double percentage = totalMarks / subjects;
        String grade = getGrade(percentage);

        System.out.println("\n===== RESULT =====");
        System.out.printf("Total Marks: %.2f / %.2f\n", totalMarks, subjects * 100.0);
        System.out.printf("Average Percentage: %.2f%%\n", percentage);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
