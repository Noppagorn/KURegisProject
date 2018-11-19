package Subject;

import java.util.ArrayList;

public class Subject {
    private String  code;
    private String name;
    private int weight;
    String []subjectBase;

    public Subject(String code, String name, int weight, String[] subjectBase) {
        this.code = code;
        this.name = name;
        this.weight = weight;
        this.subjectBase = subjectBase;
    }
    public Subject(String code, String name, int weigh) {
        this.code = code;
        this.name = name;
        this.weight = weight;
        this.subjectBase = null;
    }
    public Subject(){
        this.code = null;
        this.name = null;
        this.weight = 0;
        this.subjectBase = null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public String[] getSubjectBase() {
        return subjectBase;
    }

    @Override
    public String toString() {
        String temp = "";
        temp += "Code : " + code + '\n';
        temp += "Name : " + name + '\n';
        temp += "Wight : " + weight + '\n';
        temp += showBaseSubject();
        return temp;
    }

    private String showBaseSubject(){
        String temp = "";
        if (subjectBase == null){
            temp = "[]";
            return temp;
        }
        for (String x: subjectBase) {
            temp += "Code : " + x + '\n';
        }
        return temp;
    }
}
