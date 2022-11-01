package DTO;
import java.util.Scanner;
/**
 *
 * @author dungd
 */
public class Item {
    int value;
    String creator;
    public Item() {
        
    }
    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }
    //setters
    void setValue(int value) {
        this.value = value;
    }
    void setCreator(String creator) {
        this.creator = creator;
    }
    //getters
    int getValue() {
        return value;
    }
    public String getCreator() {
        return creator;
    }
    public void input() {
        Scanner sc = new Scanner(System.in);
        do{
            try {
                System.out.print("Enter value: ");
                int val = Integer.parseInt(sc.nextLine());
                if (val > 0) {
                    this.value = val;
                    break;
                }
                else throw new Exception();
            }
            catch(Exception e) {
                System.out.println("Value must be positive!");
            }
        }while(true);
        do{
            try {
                System.out.print("Enter creator: ");
                String cre = sc.nextLine();
                if (!cre.equals("")) {
                    this.creator = cre;
                    break;
                }
                else throw new Exception();
            }
            catch(Exception e) {
                System.out.println("Creator cannot be empty!");
            }
        }while(true);
    }
    @Override
    public String toString() {
        return "Value " + value + " Creator " + creator;
    }
}
