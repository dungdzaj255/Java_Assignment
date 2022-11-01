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
public class CarManager {
    public static void main(String [] args) {
        String fileBrand = "brands.txt";
        String fileCar = "cars.txt";
        ArrayList<String> ops = new ArrayList<String>(
            Arrays.asList("List all brands",
                          "Add a new brand",
                          "Search a brand based on its ID",
                          "Update a brand", 
                          "Save brands to the file, named brands.txt",
                          "List all cars in ascending order of brand names", 
                          "List cars based on a part of an input brand name",
                          "Add a car",
                          "Remove a car based on its ID",
                          "Update a car based on its ID",
                          "Save cars to file, named cars.txt"));
        BrandList brandList = new BrandList();
        brandList.loadFromFile(fileBrand);
        CarList carList = new CarList(brandList);
        carList.loadFromFile(fileCar);
        Menu menu = new Menu();
        int choice;
        do{          
            choice=menu.int_getChoice(ops);
            switch(choice){
                case 1:
                    brandList.listBrands();
                    break;   
                case 2:
                    brandList.addBrand();
                    break;
                case 3:
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter brand ID: ");
                    String brandID = sc.nextLine();
                    if (brandList.searchID(brandID) == -1) {
                        System.out.println("Brand ID not found !");
                    } else {
                        System.out.println(brandList.get(brandList.searchID(brandID)).toString());
                    }
                    break;
                case 4:
                    brandList.updateBrand();
                    break;
                case 5:
                    brandList.saveToFile(fileBrand);
                    System.out.println("Saved!");
                    break;
                case 6:
                    carList.listCars();
                    break;
                case 7:
                    carList.printBasedBrandName();
                    break;
                case 8:
                    carList.addCar();
                    break;
                case 9:
                     carList.removeCar();
                    break;
                case 10:
                    carList.updateCar();
                    break;
                case 11:
                    carList.saveToFile(fileCar);
                    System.out.println("Saved!");
                    break;
                default: 
                    System.out.println("Exited!");
                    break;
            }
        } while(choice>0 && choice<=ops.size());
    }
}
