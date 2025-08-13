import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Manages the list of students and file operations
public class StudentManager {
    private List<Student> studentList;
    private static final String DATA_FILE = "student_data.txt";

    public StudentManager() {
        studentList = new ArrayList<>();
        loadData();
    }

    // Add student to list
    public void add(Student s) {
        studentList.add(s);
        saveData();
    }

    // Remove student using roll ID
    public boolean delete(String rollId) {
        boolean removed = studentList.removeIf(stu -> stu.getRollId().equalsIgnoreCase(rollId));
        if (removed) {
            saveData();
        }
        return removed;
    }

    // Find student by roll ID
    public Student find(String rollId) {
        for (Student s : studentList) {
            if (s.getRollId().equalsIgnoreCase(rollId)) {
                return s;
            }
        }
        return null;
    }

    // Show all students
    public void showAll() {
        if (studentList.isEmpty()) {
            System.out.println("⚠ No records available.");
        } else {
            System.out.println("\n--- Student Records ---");
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    // Save to file
    private void saveData() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(DATA_FILE))) {
            for (Student s : studentList) {
                pw.println(s.getFullName() + "," + s.getRollId() + "," + s.getGradeLevel());
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // Load from file
    private void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 3) {
                    studentList.add(new Student(details[0], details[1], details[2]));
                }
            }
        } catch (IOException ignored) {
            // File might not exist at first run
        }
    }
}


