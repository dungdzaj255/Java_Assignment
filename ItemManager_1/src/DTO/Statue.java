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
public class Statue extends Item{
    int weight;
    String colour;
    public Statue() {
        
    }
    public Statue(int weight, String colour) {
        this.weight = weight;
        this.colour = colour;
    }
    void setWeight(int weight) {
        this.weight = weight;
    }
    void setColour(String colour) {
        this.colour = colour;
    }
    int getWeight() {
        return weight;
    }
    String getColour() {
        return colour;
    }
    @Override
    public String toString() {
        return "Value: " + value + " Creator: " + creator + " Weight: " + weight + " Colour: " + colour;
    }
    public void inputStatue() {
        input();
        Scanner sc = new Scanner(System.in);
        do{
            try {
                System.out.print("Enter weight: ");
                int w = Integer.parseInt(sc.nextLine());
                if (w > 0) {
                    this.weight = w;
                    break;
                }
                else throw new Exception();
            }
            catch(Exception e){
                System.out.println("Weight must be positive!");
            }
        }while(true);
        
        do{
            try {
                System.out.print("Enter colour: ");
                String c = sc.nextLine();
                if (!c.equals("")) {
                    this.colour = c;
                    break;
                }
                else throw new Exception();
            }
            catch(Exception e){
                System.out.println("Colour cannot be empty!");
            }
        } while(true);
    }
}
