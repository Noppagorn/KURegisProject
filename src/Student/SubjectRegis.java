package Student;

import Subject.Subject;

public class SubjectRegis extends Subject {
    private Subject subject;
    private int grade;
    private int year;
    private int term;

    public SubjectRegis(int y,int t,String code, String name, int weight, String[] subjectBase, int grade) {
        super(code, name, weight, subjectBase);
        this.grade = grade;
        term = t;
        year = y;
    }

    public SubjectRegis(int y,int t,String code, String name, int weight, int grade) {
        super(code, name, weight);
        this.grade = grade;
        term = t;
        year = y;
    }
    public SubjectRegis(int y,int t,Subject subject, int grade) {
        super(subject.getCode(), subject.getName(), subject.getWeight());
        this.grade = grade;
        term = t;
        year = y;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getGrade() {
        return grade;
    }

    public int getYear() {
        return year;
    }

    public int getTerm() {
        return term;
    }
}
