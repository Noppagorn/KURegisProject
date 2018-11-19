package Subject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ReadJson {
    public ArrayList<Subject> readFormFile(){
        Gson gson = new Gson();
        ArrayList<Subject> subjectProcess = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/DataBase/Subject.json"));
            String strJson = gson.fromJson(br, String.class);
            Type founderListType = new TypeToken<ArrayList<Subject>>(){}.getType();
            subjectProcess = gson.fromJson(strJson,founderListType);
            br.close();
            return subjectProcess;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("INVELID FIle 2332");
        }
        return subjectProcess;
    }
}
