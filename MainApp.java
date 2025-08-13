import java.util.Scanner;

// Main class to run the system
public class MainApp {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner input = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n===== WELCOME TO STUDENT MANAGEMENT MENU=====");
            System.out.println(":) How Can I Help You? :)");
            System.out.println("1 → Add Student");
            System.out.println("2 → Remove Student");
            System.out.println("3 → Search Student");
            System.out.println("4 → Display All Students");
            System.out.println("5 → Exit");
            System.out.print("Choose an option: ");
            
            while (!input.hasNextInt()) {
                System.out.print("Invalid input! Enter a number: ");
                input.next();
            }
            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter Full Name: ");
                    String name = input.nextLine();
                    System.out.print("Enter Roll ID: ");
                    String roll = input.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = input.nextLine();
                    manager.add(new Student(name, roll, grade));
                    System.out.println("✅ Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Roll ID to remove: ");
                    String rollToRemove = input.nextLine();
                    if (manager.delete(rollToRemove)) {
                        System.out.println("✅ Student removed successfully!");
                    } else {
                        System.out.println("❌ No student found with that Roll ID.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll ID to search: ");
                    String rollToSearch = input.nextLine();
                    Student found = manager.find(rollToSearch);
                    if (found != null) {
                        System.out.println("🎯 Found: " + found);
                    } else {
                        System.out.println("❌ No student found with that Roll ID.");
                    }
                    break;

                case 4:
                    manager.showAll();
                    break;

                case 5:
                    System.out.println("👋 Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("⚠ Please enter a valid choice (1-5).");
            }

        } while (option != 5);

        input.close();
    }
}

