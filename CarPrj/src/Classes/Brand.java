/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.lang.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author dungd
 */
public class Brand {
    String brandID;
    String brandName;
    String soundBrand;
    double price;
    public Brand(){
    }
    public Brand(String brandID, String brandName, String soundBrand, double price) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
    }
    //getters
    public String getBrandID() {
        return brandID;
    }
    public String getBrandName() {
        return brandName;
    }
    public String getSoundBrand() {
        return soundBrand;
    }
    public double getPrice() {
        return price;
    }
    //setters
    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public void setSoundBrand(String soundBrand) {
        this.soundBrand = soundBrand;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return brandID + ", " + brandName + ", " + soundBrand + ": " + price;
    }
}
