import java.util.Scanner;

public class Student {
    private static Students[] students = new Students[50];
    private static int studentCount = 0;
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
		
        while (true) {
            System.out.println("==== Student Grade Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update Grade");
            System.out.println("5. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addStudent(); 
                break;
                case 2: viewStudents(); 
                break;
                case 3: searchStudent(); 
                break;
                case 4: updateGrade(); 
                break;
                case 5: System.out.println("Exit..."); 
                return;
                default: System.out.println("Invalid choice");
            }
        }
    }

    private static void addStudent() {
        if (studentCount >= students.length) {
            System.out.println("Student database is full!");
            return;
        }
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == id) {
                System.out.println("Student ID already exists!");
                return;
            }
        }
        
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine();
        
        students[studentCount++] = new Students(id, name, grade);
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (studentCount == 0) {
            System.out.println("No students.");
            return;
        }
        System.out.println("Student List:");
        for (int i = 0; i < studentCount; i++) {
            students[i].displayStudent();
        }
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == id) {
                students[i].displayStudent();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    private static void updateGrade() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == id) {
                System.out.print("Enter new grade: ");
                double newGrade = scanner.nextDouble();
                scanner.nextLine();
                
                students[i].setGrade(newGrade);
                System.out.println("Grade updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
}

class Students {
    private int studentId;
    private String name;
    private double grade;

    public Students(int studentId, String name, double grade) {
        setStudentId(studentId);
        setName(name);
        setGrade(grade);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        if (studentId > 0) {
            this.studentId = studentId;
        } else {
            System.out.println("Student ID must be positive!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
        } else {
            System.out.println("Grade must be between 0 and 100!");
        }
    }

    public void displayStudent() {
        System.out.println("ID: " + studentId + ", Name: " + name + ", Grade: " + grade);
    }
}
