package Combine;

import Subject.Subject;
import Subject.ReadJson;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ComputerScience implements ScienceSubject{
    private ArrayList<Subject> subjects = null;
    public ComputerScience(){
        ReadJson readJson = new ReadJson();
        subjects = readJson.readFormFile();
    }
    @Override
    public String getSubjectName(String id) {
        for (Subject x: subjects
             ) {
            if (id.equals(x.getCode())){
                return  x.getName();
            }
        }
        throw new NoSuchElementException("NO " + id + " in Subject");
    }

    @Override
    public int getSubjectWeight(String id) {
        for (Subject x: subjects
        ) {
            if (id.equals(x.getCode())){
                return  x.getWeight();
            }
        }
        throw new NoSuchElementException("NO " + id + " in Subject");
    }

    @Override
    public String[] getSubjectBase(String id) {
        for (Subject x: subjects
        ) {
            if (id.equals(x.getCode())){
                return  x.getSubjectBase();
            }
        }
        throw new NoSuchElementException("NO " + id + " in Subject");
    }

    @Override
    public Subject getSubject(String id) {
        for (Subject x: subjects
        ) {
            if (id.equals(x.getCode())){
                return  x;
            }
        }
        throw new NoSuchElementException("NO " + id + " in Subject");
    }

}
