package TestGson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class TestGson {
    public static void main(String[] args) {
        Car c1 = new Car("t",4);
        Car c2 = new Car("2",4);
        Gson gson = new Gson();
        String json = gson.toJson(c2);
        System.out.println(json);

        //prase to object
        Car c3 = gson.fromJson(json,Car.class);
        System.out.println(c3);

        try (Writer writer = new FileWriter("car.json")) {
            Gson gsonw = new GsonBuilder().create();
            gson.toJson(json, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            BufferedReader br = new BufferedReader(new FileReader("car.json"));
            Gson gread = new Gson();
            String strJson = gread.fromJson(br, String.class);
            Car car5 = gson.fromJson(strJson,Car.class);
            System.out.println(car5.getBrand());
            System.out.println(car5);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("INVELID FIle");
        }

    }

}
