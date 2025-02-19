import java.util.Scanner;

class Student{
	private student[] students = new Student[50];
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.println("==== Student Grade Management System ====");
			System.out.println("1. Add student");
			System.out.println("2. View Student");
			System.out.println("3. Search Student");
			System.out.println("4. Update Grade");
			System.out.println("5. Exit");
			
			System.out.print("Enter your choice");
			int choice = scanner.nextInt();
			
			switch(choice){
				case 1: addStudent();
				break;
				case 2: viewStudent();
				break;
				case 3: searchStudent();
				break;
				case 4: updateGrade();
				break;
				case 5: System.out.println("Exit...");
				
				return;
			}
		}
		
	}
	
	public static void addStudent(){
		System.out.println("Enter Student ID: ");
		int id = scanner.nextInt();
		
		for(int i = 0; i < studentCount; i++){
			if(students[i].getStudentId() == id){
				System.out.println()
			}
		}
		
		System.out.println("Enter Student Name: ");
		String name = scanner.nextLine();
		
		System.out. println("Enter Student Grade: ");
		double grade = scanner.nextDouble();
	}
	
}

class Students{
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
		if(studentId > 0) {
			this.studentId = studentId;
		} else {
			System.out.println("Wrong");
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
			this.grade = grade;
		}

	
	public void displayStudent(){
		System.out.println("ID: " + studentId + "Name: " + name + "Grade: " + grade);
	}
}

