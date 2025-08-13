// Represents a single student's details
public class Student {
    private String fullName;
    private String rollId;
    private String gradeLevel;

    // Constructor
    public Student(String fullName, String rollId, String gradeLevel) {
        this.fullName = fullName;
        this.rollId = rollId;
        this.gradeLevel = gradeLevel;
    }

    // Getters
    public String getFullName() {
        return fullName;
    }

    public String getRollId() {
        return rollId;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    // Setters
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setRollId(String rollId) {
        this.rollId = rollId;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    // String representation
    @Override
    public String toString() {
        return "[Name: " + fullName + ", Roll ID: " + rollId + ", Grade: " + gradeLevel + "]";
    }
}
