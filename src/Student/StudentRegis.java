package Student;

public class StudentRegis {
    private String subject;
    private char grade;
    private int year;
    private int term;

    public StudentRegis(String subject, char grade, int year, int term) {
        this.subject = subject;
        this.grade = grade;
        this.year = year;
        this.term = term;
    }

    public String getSubject() {
        return subject;
    }

    public char getGrade() {
        return grade;
    }

    public int getYear() {
        return year;
    }

    public int getTerm() {
        return term;
    }
}
