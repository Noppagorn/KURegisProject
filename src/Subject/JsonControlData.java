package Subject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;

public class JsonControlData {
    private String fileSep = System.getProperty("file.separator");
    public void writeToJson(ArrayList words){
        Gson gson = new Gson();
        String json = gson.toJson(words);
        try {
            File newDir = null;
            newDir = new File(getPathJarFile()+fileSep+"DataBase");
            newDir.mkdir();
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(getPathJarFile()+fileSep+"DataBase/SubjectJson.json")));
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
            BufferedReader reader = new BufferedReader(new FileReader(getPathJarFile()+fileSep+"DataBase/SubjectJson.json"));
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

    private static String getPathJarFile() throws UnsupportedEncodingException {
        URL url = JsonControlData.class.getProtectionDomain().getCodeSource().getLocation();
        String jarpath = URLDecoder.decode(url.getFile(),"UTF-8");
        String parentPath = new File(jarpath).getParentFile().getPath();
        return parentPath;
    }

    public boolean checkFileExist() throws UnsupportedEncodingException {
        File file = new File(getPathJarFile()+fileSep+"DataBase/SubjectJson.json");
        return file.exists();
    }
}
