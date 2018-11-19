package Student;

import java.util.ArrayList;

public class Student {
    private String id;
    private String name;
    private int year;
    ArrayList<StudentRegis> stregis = new ArrayList<StudentRegis>();

    public Student(String id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }
    public void add(StudentRegis stre){
        this.stregis.add(stre);
    }
    public void add(ArrayList<StudentRegis> stre){
        this.stregis.addAll(stre);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<StudentRegis> getStregis() {
        return stregis;
    }

    @Override
    public String toString() {
        String temp = "";
        temp += "ID : " + id + "\n";
        temp += "Name : " + name + "\n";
        for (StudentRegis s: stregis
             ) {
            temp += "ID :" + s.getSubject() + " Grade : " + s.getGrade() + " Term : " + s.getTerm();
            temp += " Years : " + s.getYear() + "\n";
        }
        return temp;
    }
}
