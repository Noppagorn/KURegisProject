
import Combine.ComScienceStudent;
import Student.Student;
import Student.AllStudent;
import  Student.CreateStudent;
import Subject.Subject;
import Subject.ReadJson;
import Subject.ProMain;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ReadJson readJson = new ReadJson();
        ArrayList<Subject> subjects = readJson.readFormFile();
        ComScienceStudent cStd = new ComScienceStudent();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Q to quit a to add s to show");
            char choice = sc.nextLine().charAt(0);
            System.out.println(choice);
            if (choice == 'q'){
                break;
            }
            else if(choice == 'a'){
                String id = sc.nextLine();
                String name = sc.nextLine();
                int year = sc.nextInt();
                String space = sc.nextLine();
                cStd.addStudent(new Student(id,name,year));
                cStd.write();
            }
            else if (choice == 's'){
                for (Student x: cStd.getAllStudent()
                     ) {
                    System.out.println(x);
                }
            }
            else if (choice == 'r'){
                String id = sc.nextLine();
                cStd.deleateById(id);
                cStd.write();
            }
        }

//        AllStudent allStudent = new AllStudent();
//        CreateStudent createStudent = new CreateStudent();
//        allStudent.write(createStudent.ElementStudent());
//        ArrayList<Student> students = allStudent.read();
//        students.add(new Student("6010405432","Wachirawit",2));
//        for (Student x: students
//             ) {
//            System.out.println(x);
//        }
//        ComScienceStudent csstd = new ComScienceStudent();
//        csstd.write();
//        ComScienceStudent csStd = new ComScienceStudent();
//        csStd.addStudent(new Student("6010405432","Wachirawit",2));
//        csStd.write();
    }
}
