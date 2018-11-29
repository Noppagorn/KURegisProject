package Student;

import Subject.Subject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;

public class Student {
    ArrayList<SubjectRegis> subjects;
    private String fileSep = System.getProperty("file.separator");

    public void writeToJson(ArrayList subjects){
        Gson gson = new Gson();
        String json = gson.toJson(subjects);
        try {
            File newDir = null;
            newDir = new File(getPathJarFile()+fileSep+"DataBase");
            newDir.mkdir();
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(getPathJarFile()+fileSep+"DataBase/StudentJson.json")));
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
            BufferedReader reader = new BufferedReader(new FileReader(getPathJarFile()+fileSep+"DataBase/StudentJson.json"));
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
    private static String getPathJarFile() throws UnsupportedEncodingException {
        URL url = Student.class.getProtectionDomain().getCodeSource().getLocation();
        String jarpath = URLDecoder.decode(url.getFile(),"UTF-8");
        String parentPath = new File(jarpath).getParentFile().getPath();
        return parentPath;
    }

    public boolean checkFileExist() throws UnsupportedEncodingException {
        File file = new File(getPathJarFile()+fileSep+"DataBase/StudentJson.json");
        return file.exists();
    }
}
