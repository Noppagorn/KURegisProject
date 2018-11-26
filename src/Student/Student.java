package Student;

import Subject.Subject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;

public class Student {
    ArrayList<Subject> subjects = null;

    public Student(){
        subjects = new ArrayList<Subject>();
        subjects.add(new Subject("01418211","java", 3));
        subjects.remove(0);
        writeToJson(subjects);
        readFromJson();
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
    public ArrayList<Subject> readFromJson(){
        Gson gson = new Gson();
        ArrayList<Subject> tempHash = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("DataBase/StudentJson.json"));
            ArrayList<Subject> retMap = new Gson().fromJson(
                    reader, new TypeToken<ArrayList<Subject>>() {}.getType()
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

    public ArrayList<Subject> getStrudentSub (){
        return subjects;
    }
}
