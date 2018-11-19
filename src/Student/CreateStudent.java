package Student;

import java.util.ArrayList;

public class CreateStudent {
    public ArrayList<Student> ElementStudent(){
        Student student = new Student("6010405335","Noppagorn" ,2 );
        student.add(new StudentRegis("01418112",'A',1,1));
        student.add(new StudentRegis("01418116",'A',2,1));
        ArrayList<Student> Students = new ArrayList<Student>();
        Students.add(student);
        return Students;
    }
}
