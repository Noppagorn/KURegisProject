package Combine;

import Student.Student;
import Subject.Subject;

import java.util.ArrayList;

public interface ScienceSubject {
    public String getSubjectName(String id);
    public int getSubjectWeight(String id);
    public String[] getSubjectBase(String id);
    public Subject getSubject(String id);
    public ArrayList<Subject> getAllSubject();
}
