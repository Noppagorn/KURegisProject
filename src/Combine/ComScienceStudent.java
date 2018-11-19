package Combine;

import Student.Student;
import Subject.Subject;
import Student.AllStudent;
import Student.StudentRegis;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ComScienceStudent implements ScienceStudent {

    private ArrayList<Student> students = null;
    public ComScienceStudent(){
        AllStudent allStudent = new AllStudent();
        students = allStudent.read();

    }
    @Override
    public Student getStudent(String id) {
        for (Student x: students
             ) {
            if (id.equals(x.getName())){
                return x;
            }
        }
        throw new NoSuchElementException("NO " + id + " in Student");
    }

    @Override
    public String getStudentName(String id) {
        for (Student x: students
        ) {
            if (id.equals(x.getName())){
                return x.getName();
            }
        }
        throw new NoSuchElementException("NO " + id + " in Student");
    }

    @Override
    public int getStudentyear(String id) {
        for (Student x: students
        ) {
            if (id.equals(x.getName())){
                return x.getYear();
            }
        }
        throw new NoSuchElementException("NO " + id + " in Student");
    }

    @Override
    public ArrayList<StudentRegis> getStudentRegis(String id) {
        for (Student x: students
        ) {
            if (id.equals(x.getName())){
                return x.getStregis();
            }
        }
        throw new NoSuchElementException("NO " + id + " in Student");
    }

    @Override
    public void addSubjectRegis(String id, ArrayList<StudentRegis> sbj) {
        for (Student x: students
        ) {
            if (id.equals(x.getName())){
                x.add(sbj);
            }
        }
        throw new NoSuchElementException("NO " + id + " in Student");
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }
    @Override
    public void write(){
        AllStudent allStudent = new AllStudent();
        allStudent.write(students);
    }
    @Override
    public ArrayList<Student> getAllStudent(){
        return students;
    }
    @Override
    public void deleateById(String id){
        int temp = -1;
        for (int i = 0 ; i < students.size();i++){
            if (students.get(i).getId().equals(id)){
                temp = i;
            }
        }
        if (temp != -1){
            students.remove(temp);
        }
    }
}
