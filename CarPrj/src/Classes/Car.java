/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
/**
 *
 * @author dungd
 */
public class Car implements Comparable<Car> {
    String carID;
    Brand brand;
    String color;
    String frameID;
    String engineID;
    public Car() {}
    public Car (String carID, Brand brand, String color, String frameID, String engineID) {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }
    //Getters
    public String getCarID() {
        return carID;
    }
    public Brand getBrand() {
        return brand;
    }
    public String getColor() {
        return color;
    }
    public String getFrameID() {
        return frameID;
    }
    public String getEngineID() {
        return engineID;
    }
    //Setters
    public void setCarID(String carID) {
        this.carID = carID;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }
    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }
    public int comparedTo(Car c) {
        int d = this.brand.brandName.compareTo(c.brand.brandName);
        if (d!=0) return d;
        return this.carID.compareTo(c.carID);
    }
    @Override
    public String toString() {
        return carID + ", " + brand.brandID + ", " + color + ", " + frameID + ", " + engineID;
    }
    public String screenString() {
        return brand + ",\n" + carID + ", " + color + ", " + frameID + ", " + engineID;
    }
    @Override
    public int compareTo(Car c) {
        return this.getBrand().getBrandName().compareTo(c.getBrand().getBrandName());
    }
}
