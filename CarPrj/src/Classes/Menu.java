/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.*;

/**
 *
 * @author dungd
 */
public class Menu{
    Scanner scanner = new Scanner (System.in);
    
    //For the menu list
    public int int_getChoice (ArrayList<String> options) {
        int response;
        System.out.println("");
        for (int i=0; i<options.size(); i++) {
            System.out.println((i+1) + " - " + options.get(i));
        }
        System.out.print("Please choose an option 1..11:  ");
        response = scanner.nextInt();
        return response;
    }

    //Get user choice as an integer
    public int int_getChoice(BrandList brand) {
        int response;
        int n = brand.size();
        for (int i = 0; i < n; i++) {
            System.out.println("" + (i+1) + ". " + brand.get(i));
        }
        System.out.print("Please choose an option 1..11:  ");
        response = scanner.nextInt();
        return response;
    }

    //Get user choice as an object in the list
    public Brand ref_getChoice(BrandList options) {
        int response;
        int N = options.size();
        do {
            response = int_getChoice(options);
        } while ((response < 0) || (response > N));
        return options.get(response - 1);
    }
}
