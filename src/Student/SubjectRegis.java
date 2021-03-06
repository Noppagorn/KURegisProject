package Student;

import Subject.Subject;

public class SubjectRegis extends Subject {
    private Subject subject;
    private String grade;
    private int year;
    private int term;

    public SubjectRegis(int y,int t,String code, String name, int weight, String[] subjectBase, String grade) {
        super(code, name, weight, subjectBase);
        this.grade = grade;
        term = t;
        year = y;
    }

    public SubjectRegis(int y,int t,String code, String name, int weight, String grade) {
        super(code, name, weight);
        this.grade = grade;
        term = t;
        year = y;
    }
    public SubjectRegis(int y,int t,Subject subject, String grade) {
        super(subject.getCode(), subject.getName(), subject.getWeight());
        this.grade = grade;
        term = t;
        year = y;
    }

    public Subject getSubject() {
        return subject;
    }

    public String getGrade() {
        return grade;
    }

    public int getYear() {
        return year;
    }

    public int getTerm() {
        return term;
    }
}
