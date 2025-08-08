import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class StudentsRecordSystem {

    public static void main(String[] args) {
        // Use ArrayList to store a dynamic collection of Student objects [cite: 9]
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("1. Add Student"); // Create
            System.out.println("2. View All Students"); // Read
            System.out.println("3. Update Student"); // Update
            System.out.println("4. Delete Student"); // Delete
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    addStudent(scanner, studentList);
                    break;
                case 2:
                    viewStudents(studentList);
                    break;
                case 3:
                    updateStudent(scanner, studentList);
                    break;
                case 4:
                    deleteStudent(scanner, studentList);
                    break;
                case 5:
                    System.out.println("Exiting application... Best of Luck! [cite: 30]");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addStudent(Scanner scanner, ArrayList<Student> list) {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        list.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("\n--- All Student Records ---");
            for (Student student : list) {
                System.out.println(student); // Uses the toString() method from the Student class
            }
        }
    }

    private static void updateStudent(Scanner scanner, ArrayList<Student> list) {
        System.out.print("Enter the ID of the student to update: ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student studentToUpdate = null;
        for (Student student : list) {
            if (student.getId() == idToUpdate) {
                studentToUpdate = student;
                break;
            }
        }

        if (studentToUpdate != null) {
            System.out.print("Enter new Name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new Marks: ");
            double newMarks = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            studentToUpdate.setName(newName);
            studentToUpdate.setMarks(newMarks);
            System.out.println("Student record updated successfully!");
        } else {
            System.out.println("Student with ID " + idToUpdate + " not found.");
        }
    }

    private static void deleteStudent(Scanner scanner, ArrayList<Student> list) {
        System.out.print("Enter the ID of the student to delete: ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Iterator<Student> iterator = list.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == idToDelete) {
                iterator.remove();
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Student record deleted successfully!");
        } else {
            System.out.println("Student with ID " + idToDelete + " not found.");
        }
    }
}
