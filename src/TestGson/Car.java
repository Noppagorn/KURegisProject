package TestGson;

public class Car {
    public String brand;
    public int    doors;

    public Car(String brand, int doors) {
        this.brand = brand;
        this.doors = doors;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        String temp = "";
        temp += "Band : " + brand + " " + "Doors : " + doors;
        return temp;
    }
}