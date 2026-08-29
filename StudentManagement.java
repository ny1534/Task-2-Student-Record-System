import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1: add(); break;
                case 2: view(); break;
                case 3: update(); break;
                case 4: delete(); break;
                case 5: return;
                default: System.out.println("Invalid!");
            }
        }
    }

    static void add() {
        System.out.print("Enter ID: "); int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: "); String name = sc.nextLine();
        System.out.print("Enter Marks: "); double marks = sc.nextDouble();
        students.add(new Student(id, name, marks));
        System.out.println("Student Added Successfully!");
    }

    static void view() {
        if (students.isEmpty()) { System.out.println("No records found!"); return; }
        for (Student s : students) s.display();
    }

    static void update() {
        System.out.print("Enter ID to Update: "); int id = sc.nextInt();
        for (Student s : students) {
            if (s.getId() == id) {
                sc.nextLine();
                System.out.print("New Name: "); s.setName(sc.nextLine());
                System.out.print("New Marks: "); s.setMarks(sc.nextDouble());
                System.out.println("Updated!");
                return;
            }
        }
        System.out.println("ID not found!");
    }

    static void delete() {
        System.out.print("Enter ID to Delete: "); int id = sc.nextInt();
        boolean removed = students.removeIf(s -> s.getId() == id);
        if(removed) System.out.println("Deleted!");
        else System.out.println("ID not found!");
    }
}