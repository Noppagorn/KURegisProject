package Subject;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

public class ProMain {
    public void createSubject(){
        //Math
        Subject subject1 = new Subject("01417111","Calculus I",3);
        Subject subject2 = new Subject("01417112","Calculus II",3,new String[] {"01417111"});
        Subject subject3 = new Subject("01417322","Principles of Statics",3,new String[] {"01417112"});
        Subject subject4 = new Subject("01417322","Introductory Linear Algebra",3,new String[] {"01417112"});

        //Major
        Subject subject5 = new Subject("01418114","Introduction to Computer Science",2);
        Subject subject6 = new Subject("01418112","Fundamental Programming Concepts",3,new String[] {"01418114"});
        Subject subject7 = new Subject("01418131","Digital Computer Logic",3);
        Subject subject8 = new Subject("01418113","Computer Programming",3,new String[] {"01418112"});
        Subject subject9 = new Subject("01418132","Fundamentals of Computing",4);
        Subject subject10 = new Subject("01418211","Software Construction",3,new String[] {"01417113"});
        Subject subject11 = new Subject("01418231","Data Structures",3,new String[] {"01418113"});
        Subject subject12 = new Subject("01418221","Fundamentals of Database Systems",3,new String[] {"01418113"});
        Subject subject13 = new Subject("01418232","Algorithm Design and Analysis",3,new String[] {"01418132","01418231"});
        Subject subject14 = new Subject("01418233","Assembly Language and Computer Architecture",4,new String[] {"01418113","01418131"});
        Subject subject15 = new Subject("01418321","System Analysis and Design",3,new String[] {"01418211","01418221"});
        Subject subject16 = new Subject("01418331","Operating Systems",4,new String[] {"01418233"});
        Subject subject17 = new Subject("01418341","Intellectual Property for Software and Digital Contents",3);
        Subject subject18 = new Subject("01418497","Seminar",3,new String[] {"01418221","01418232","01418233"});
        Subject subject19 = new Subject("01418332","Information System Security",3,new String[] {"01418331"});
        Subject subject20 = new Subject("01418333","Automata Theory",2,new String[] {"01418132"});
        Subject subject21 = new Subject("01418334","Compiler Techniques",2,new String[] {"01418333"});
        Subject subject22 = new Subject("01418351","Computer Communications and Protocols",3,new String[] {"01418331"});
        Subject subject23 = new Subject("01418390","Cooperative Education Preparation",1,new String[] {"01418390"});
        Subject subject24 = new Subject("01418490","Cooperative Education",6,new String[] {"01418390"});
        Subject subject25 = new Subject("01418499","Computer Science Project",3,new String[] {"01418321"});


        ArrayList<Subject> subjects = new ArrayList<Subject>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);
        subjects.add(subject4);
        subjects.add(subject5);
        subjects.add(subject6);
        subjects.add(subject7);
        subjects.add(subject8);
        subjects.add(subject9);
        subjects.add(subject10);

        subjects.add(subject11);
        subjects.add(subject12);
        subjects.add(subject13);
        subjects.add(subject14);
        subjects.add(subject15);
        subjects.add(subject16);
        subjects.add(subject17);
        subjects.add(subject18);
        subjects.add(subject19);
        subjects.add(subject20);

        subjects.add(subject21);
        subjects.add(subject22);
        subjects.add(subject23);
        subjects.add(subject24);
        subjects.add(subject25);


        Gson gson = new Gson();
        String json = gson.toJson(subjects);
        WriteToJson writeToJson = new WriteToJson();
        ReadJson readJson = new ReadJson();
        try {
            writeToJson.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ProMain proMain = new ProMain();
        proMain.createSubject();
    }
}
