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
public class Menu {
    public static int getChoice(Object[] options) {
        for (int i=0; i<options.length; i++) {
            System.out.println((i+1) + ". " + options[i]);
        }
        System.out.print("Input your choice:  ");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }
}