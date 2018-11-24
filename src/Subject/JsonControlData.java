package Subject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class WriteToJson {
    public void writeToJson(ArrayList words){
        Gson gson = new Gson();
        String json = gson.toJson(words);
        try {
            File newDir = null;
            newDir = new File("DataBase");
            newDir.mkdir();
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("DataBase/JsonWord.json")));
            pw.println(json);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
