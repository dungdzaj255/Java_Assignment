/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.util.*;
import java.io.*;
/**
 *
 * @author dungd
 */
public class BrandList extends ArrayList<Brand>{
    Scanner sc = new Scanner(System.in);
    public BrandList() { }
    public boolean loadFromFile(String filename) {
        try {
            File f = new File(filename);
            if(!f.exists()) return false;
            else {
                FileReader fr = new FileReader(f);
                BufferedReader bf = new BufferedReader(fr); 
                String details;
                while ((details = bf.readLine()) != null) {
                    String[] arr = details.split(",");
                    String brandID = arr[0].trim();
                    String brandName = arr[1].trim();
                    String soundBrand = arr[2].split(":")[0].trim();
                    double price = Double.parseDouble(arr[2].split(":")[1].trim());
                    this.add(new Brand(brandID, brandName, soundBrand, price));
                }
                bf.close(); 
                fr.close();
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
         return true;
    }
    public boolean saveToFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw);
            for (Brand x:this) {
                pw.println(x);
            }
            pw.close(); 
            fw.close();
            return true;
        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
    }
    public int searchID (String brandID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getBrandID().equals(brandID)) return i;
        }
        return -1;
    }
    public Brand getUserChoice() {
        Menu mnu = new Menu();
        return (Brand)mnu.ref_getChoice(this);
    }
    public void addBrand() {
        String brandID, brandName, soundBrand;
        double price;
        do {
            System.out.print("Enter Brand ID: ");
            brandID = sc.nextLine();
            if (searchID(brandID)>=0) System.out.println("Brand ID can not be duplicated.");
            else break;
        } while (true);
        do {
            System.out.print("Enter Brand Name: ");
            brandName = sc.nextLine();
            if (brandName.equals("")) System.out.println("The brand name can not be blank.");
            else break;
        } while (true);
        do {
            System.out.print("Enter Sound Manufacturer: ");
            soundBrand = sc.nextLine();
            if (soundBrand.equals("")) System.out.println("The sound manufacturer can not be blank.");
            else break;
        } while (true);
        do {
            try {
                System.out.print("Enter price: ");
                price = Double.parseDouble(sc.nextLine());
                if (price<=0) System.out.println("The price must be a positive real number.");
                else break;
            }
            catch(NumberFormatException e) {
                System.out.println("The price must be a positive real number.");
            }
        } while (true);
        this.add(new Brand(brandID, brandName, soundBrand, price));
        System.out.println("New brand has been added!");
    }
    public void updateBrand() {
        String brandID, brandName, soundBrand;
        double price;
        System.out.print("Enter brand ID to be updated: ");
        brandID = sc.nextLine();
        int pos = searchID(brandID);
        if (pos<0) System.out.println("Not found!");
        else {
            do {
                System.out.print("Enter new Brand Name: ");
                brandName = sc.nextLine();
                if (brandName.equals("")) System.out.println("The brand name can not be blank.");
                else {
                    this.get(pos).setBrandName(brandName);
                    break;
                }
            } while (true);
            do {
                System.out.print("Enter new Sound Manufacturer: ");
                soundBrand = sc.nextLine();
                if (soundBrand.equals("")) System.out.println("The sound manufacturer can not be blank.");
                else {
                    this.get(pos).setSoundBrand(soundBrand);
                    break;
                }
            } while (true);
            do {
                try {
                   System.out.print("Enter new price: ");
                    price = Double.parseDouble(sc.nextLine());
                    if (price<=0) System.out.println("The price must be a positive real number.");
                    else {
                        this.get(pos).setPrice(price);
                        break;
                    } 
                }
                catch(NumberFormatException e) {
                    System.out.println("The price must be a positive real number.");
                }
            } while (true);
            System.out.println("Brand " + brandID + " has been updated!");
        }
    }
    public void listBrands() {
        if (this.isEmpty()) {
            System.out.println("Empty List.");
        }
        System.out.println("\nBRAND LIST");
        System.out.println("------------------------------");
        for (int i=0; i<this.size(); i++) {
            System.out.println(this.get(i));
        }
    }
}
