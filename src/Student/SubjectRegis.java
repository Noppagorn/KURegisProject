package Student;

import Subject.Subject;

public class SubjectRegis {
    private Subject subject;
    private int year;
    private int term;
    private int grade;

    public SubjectRegis(Subject subject, int year, int term, int grade) {
        this.subject = subject;
        this.year = year;
        this.term = term;
        this.grade = grade;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getYear() {
        return year;
    }

    public int getTerm() {
        return term;
    }

    public int getGrade() {
        return grade;
    }
}
