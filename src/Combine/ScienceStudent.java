package Combine;

import Student.Student;
import Student.StudentRegis;
import Subject.Subject;

import java.util.ArrayList;

public interface ScienceStudent {

    public ArrayList<Student>getAllStudent();
    public Student getStudent(String id);
    public void addStudent(Student student);
    public String getStudentName(String id);
    public int getStudentyear(String id);
    public ArrayList<StudentRegis> getStudentRegis(String id);
    public void addSubjectRegis(String id,ArrayList<StudentRegis> sbj);
    public void write();
    public void deleateById(String id);
}
