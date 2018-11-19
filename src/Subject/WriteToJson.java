package Subject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class WriteToJson {
    public void write(String json) throws IOException {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter("src/DataBase/Subject.json")) {
            gson.toJson(json, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
