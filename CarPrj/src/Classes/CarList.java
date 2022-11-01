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
public class CarList extends ArrayList<Car>{
    Scanner sc = new Scanner(System.in);
    BrandList brandList;
    public CarList(BrandList bList) {
        brandList = bList;
    }
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
                    String carID = arr[0].trim();
                    Brand brand = brandList.get(brandList.searchID(arr[1].trim()));
                    String color = arr[2].trim();
                    String frameID = arr[3].trim();
                    String engineID = arr[4].trim();
                    this.add(new Car(carID, brand, color, frameID, engineID));
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
            for (Car x:this) {
                pw.println(x);
            }
            pw.close(); 
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return true;
    }
    public int searchID (String carID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCarID().equals(carID)) return i;
        }
        return -1;
    }
    public int searchFrame (String frameID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getFrameID().equals(frameID)) return i;
            System.out.println(i+"\n");
        }
        return -1;
    }
    public int searchEngine (String engineID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getEngineID().equals(engineID)) return i;
        }
        return -1;
    }
    public void addCar() {
        String carID, color, frameID, engineID;
        int pos = 0;
        boolean valid = true;
        do {
            System.out.print("Enter Car ID: ");
            carID = sc.nextLine();
            if (searchID(carID)>=0) System.out.println("Car ID can not be duplicated.");
            else break;
        } while (true);
        Menu menu = new Menu();
        Brand b = (Brand)menu.ref_getChoice(brandList);
        do {
            System.out.print("Enter car's color: ");
            color = sc.nextLine();
            if (color.equals("")) System.out.println("Color can not be blank.");
            else break;
        } while (true);
        do {
            System.out.print("Enter frame ID (F00000): ");
            frameID = sc.nextLine();
            pos = searchFrame(frameID);
            valid = frameID.matches("^F\\d{5}$");
            if (frameID.equals("") || pos >= 0 || !valid) System.out.println("Frame ID can not be "
                    + "blank and must be in the 'F00000' format and can not be duplicated.");
        } while (pos >= 0 || (!valid) || frameID.equals(""));
        do {
            System.out.print("Enter engine ID (E00000): ");
            engineID = sc.nextLine();
            pos = searchEngine(engineID);
            valid = engineID.matches("^E\\d{5}$");
            if (engineID.equals("") || pos >= 0 || !valid) System.out.println("Engine ID can not be "
                    + "blank and must be in the 'E00000' format and can not be duplicated.");
        } while (pos >= 0 || (!valid) || engineID.equals(""));
        this.add(new Car(carID, b, color, frameID, engineID));
        System.out.println("New car has been added!");
    }
    public void printBasedBrandName() {
        String aPartOfBrandName;
        System.out.print("Enter the brand to be printed: ");
        aPartOfBrandName = sc.nextLine();
        int count=0;
        for (int i=0; i<this.size(); i++) {
            Car c = get(i);
            if (c.brand.brandName.contains(aPartOfBrandName)) {
                System.out.println(c.screenString());
                count++;
            }
        }
        if (count==0) {
            System.out.println("No car is detected!");
        }
    }
    public boolean removeCar() {
        String removedID;
        System.out.print("Enter the car ID to be removed: ");
        removedID = sc.nextLine();
        int pos = searchID(removedID);
        if (pos<0) {
            System.out.println("Not found!");
            return false;
        }
        else{
            this.remove(pos);
        }
        System.out.println("Car was removed!");
        return true;
    }
    public boolean updateCar() {
        String updatedID,newColor, newFrameID, newEngineID;
        boolean valid=true;
        System.out.print("Enter the car ID to be updated: ");
        updatedID = sc.nextLine();
        int pos = searchID(updatedID);
        System.out.println(pos+"\n");
        if (pos<0) {
            System.out.println("Not found!");
            return false;
        }
        else {
            Menu menu = new Menu();
            Brand b = (Brand)menu.ref_getChoice(brandList); 
            do {
                System.out.print("Enter new car's color: ");
                newColor = sc.nextLine();
                if (newColor.equals("")) System.out.println("Color can not be blank.");
                else {
                    this.get(pos).setColor(newColor);
                    break;
                }
            } while (true);
            do {
                System.out.print("Enter new frame ID (F00000): ");
                newFrameID = sc.nextLine();
                valid = newFrameID.matches("^F\\d{5}$");
                if (searchFrame(newFrameID) != -1 || (!valid) || newFrameID.equals("")) {
                    System.out.println("Frame ID can not be "
                    + "blank and must be in the 'F00000' format and can not be duplicated.");
                }
                else {
                    this.get(pos).setFrameID(newFrameID);
                    break;
                }
            } while (true);
            do {
                System.out.print("Enter new engine ID (E00000): ");
                newEngineID = sc.nextLine();
                valid = newEngineID.matches("^E\\d{5}$");
                if (newEngineID.equals("") || searchEngine(newEngineID) != -1 || !valid) System.out.println("Engine ID can not be "
                    + "blank and must be in the 'E00000' format and can not be duplicated.");
                else {
                    this.get(pos).setEngineID(newEngineID);
                    break;
                }
            } while (true);
            
        }
        System.out.println("Car " + updatedID + " has been updated!");
        return true;
    }
    public void listCars() {
        if (this.isEmpty()) {
            System.out.println("Empty List.");
        }
        Collections.sort(this);
        System.out.println("\nCAR LIST");
        System.out.println("------------------------------");
        for (int i=0; i<this.size(); i++) {
            Car c = get(i);
            System.out.println(c.screenString());
        }
    }
}
