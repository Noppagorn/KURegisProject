package Subject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;

public class JsonControlData {
    public void writeToJson(ArrayList words){
        Gson gson = new Gson();
        String json = gson.toJson(words);
        try {
            File newDir = null;
            newDir = new File("DataBase");
            newDir.mkdir();
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("DataBase/SubjectJson.json")));
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
            BufferedReader reader = new BufferedReader(new FileReader("DataBase/SubjectJson.json"));
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
}
