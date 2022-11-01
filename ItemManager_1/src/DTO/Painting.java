/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author dungd
 */
public class Painting extends Item {
    int height;
    int width;
    boolean isWatercolour;
    boolean isFramed;
    public Painting() {
        
    }
    public Painting(int height, int width, boolean isWatercolour, boolean isFramed) {
        this.height = height;
        this.width = width;
        this.isWatercolour = isWatercolour;
        this.isFramed = isFramed;
    }
    void setHeight(int height) {
        this.height = height;
    }
    void setWidth(int width) {
        this.width = width;
    }
    void setIsWatercolour(boolean isWatercolour) {
        this.isWatercolour = isWatercolour;
    }
    void setIsFramed(boolean isWatercolour) {
        this.isFramed = isFramed;
    }
    int getHeight() {
        return height;
    }
    int getWidth() {
        return width;
    }
    boolean setIsWatercolour() {
        return isWatercolour;
    }
    boolean setIsFramed() {
        return isFramed;
    }
    @Override
    public String toString() {
        return "Value: " + value + " Creator: " + creator + " Height: " + height + " Width: " + width + " Water Colour: " + isWatercolour + " Framed: " + isFramed;
    }
    public void inputPainting() {
        input();
        Scanner sc = new Scanner(System.in);
        do{
            try {
                System.out.print("Enter height: ");
                int h = Integer.parseInt(sc.nextLine());
                if (h > 0) {
                    this.height = h;
                    break;
                }
                else throw new Exception();
            }
            catch(Exception e){
                System.out.println("Height must be positive!");
            }
        }while(true);
        
        do{
            try {
                System.out.print("Enter width: ");
                int w = Integer.parseInt(sc.nextLine());
                if (w > 0) {
                    this.width = w;
                    break;
                }
                else throw new Exception();
            }
            catch(Exception e){
                System.out.println("Width cannot be empty!");
            }
        } while(true);
        do {
            System.out.print("Water Colour? (Yes/No): ");
            String wc = sc.nextLine();
            if (wc.equals("Yes")) {
                this.isWatercolour = true;
                break;
            }
            else if (wc.equals("No")) {
                this.isWatercolour = false;
                break;
            }
            else System.out.println("Water Colour is not valid!");
        } while(true);
        do {
            System.out.print("Framed? (Yes/No): ");
            String wc = sc.nextLine();
            if (wc.equals("Yes")) {
                this.isFramed = true;
                break;
            }
            else if (wc.equals("No")) {
                this.isFramed = false;
                break;
            }
            else System.out.println("Frame is not valid!");
        } while(true);
    }
}
