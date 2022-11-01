package DTO;
import java.util.Scanner;
/**
 *
 * @author dungd
 */
public class Vase extends Item {
    int height;
    String material;
    public Vase() {
        
    }
    public Vase(int height, String material) {
        this.height = height;
        this.material = material;
    }
    void setHeight(int height) {
        this.height = height;
    }
    void setMaterial(String material) {
        this.material = material;
    }
    int getHeight() {
        return height;
    }
    String getMaterial() {
        return material;
    }
    @Override
    public String toString() {
        return "Value: " + value + " Creator: " + creator + " Height: " + height + " Material: " + material;
    }
    public void inputVase() {
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
                System.out.print("Enter material: ");
                String m = sc.nextLine();
                if (!m.equals("")) {
                    this.material = m;
                    break;
                }
                else throw new Exception();
            }
            catch(Exception e){
                System.out.println("Material cannot be empty!");
            }
        } while(true);
    }
}
