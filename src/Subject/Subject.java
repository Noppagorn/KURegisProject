package Subject;

import java.util.ArrayList;

public class Subject {
    private String  code;
    private String name;
    private int weight;
    String []subjectBase;
    private boolean check;
    private int level;
    public Subject(String code, String name, int weight,boolean check,int level, String[] subjectBase) {
        this.code = code;
        this.name = name;
        this.weight = weight;
        this.check = check;
        this.level = level;
        this.subjectBase = subjectBase;
    }
    public Subject(String code, String name, int weight,boolean check,int level) {
        this.code = code;
        this.name = name;
        this.weight = weight;
        this.check = check;
        this.level = level;
        this.subjectBase = null;
    }

    public boolean isCheck() {
        return check;
    }

    public int getLevel() {
        return level;
    }

    public void setCheck(boolean check) {
        this.check = check;
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
