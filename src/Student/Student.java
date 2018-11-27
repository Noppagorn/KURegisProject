package Student;

import Subject.Subject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;

public class Student {
    ArrayList<SubjectRegis> subjects;

    public Student(){
        subjects = new ArrayList<SubjectRegis>();
        //subjects.add(new SubjectRegis(1,1,new Subject("01418211","java", 3),3));
        //writeToJson(subjects);
        readFromJson();
        for (SubjectRegis x: subjects
             ) {
            System.out.println(x.getCode());
        }
    }

    public void writeToJson(ArrayList subjects){
        Gson gson = new Gson();
        String json = gson.toJson(subjects);
        try {
            File newDir = null;
            newDir = new File("DataBase");
            newDir.mkdir();
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("DataBase/StudentJson.json")));
            pw.println(json);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<SubjectRegis> readFromJson(){
        Gson gson = new Gson();
        ArrayList<SubjectRegis> tempHash = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("DataBase/StudentJson.json"));
            ArrayList<SubjectRegis> retMap = new Gson().fromJson(
                    reader, new TypeToken<ArrayList<SubjectRegis>>() {}.getType()
            );
            reader.close();
            return retMap;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public ArrayList<SubjectRegis> getStrudentSub (){
        return subjects;
    }
}
