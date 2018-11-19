package Student;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class AllStudent {
    public void write(ArrayList<Student> st){
        Gson gson = new Gson();
        String json = gson.toJson(st);
        try (Writer writer = new FileWriter("src/DataBase/Students.json")) {
            gson.toJson(json, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Student> read(){
        Gson gson = new Gson();
        ArrayList<Student> StudentProcess = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/DataBase/Students.json"));
            String strJson = gson.fromJson(br, String.class);
            Type founderListType = new TypeToken<ArrayList<Student>>(){}.getType();
            StudentProcess = gson.fromJson(strJson,founderListType);
            br.close();
            return StudentProcess;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("INVELID FIle");
        }
        return StudentProcess;
    }
}
