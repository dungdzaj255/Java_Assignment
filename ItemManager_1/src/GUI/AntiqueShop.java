package GUI;

import DTO.*;
import java.util.Scanner;
/**
 *
 * @author dungd
 */
public class AntiqueShop {
    public static void main(String[] args){
        String[] options={"add a new vase","add a new statue","add a new painting","display all items", 
            "find the items by the creator", "update the item by its index", "remove the item by its index",
            "display the list of vase items","sorts items in ascending order based on their values","exit"};
        int choice=0;
        ItemList obj = new ItemList();
        do{          
            choice=Menu.getChoice(options);
            switch(choice){
                case 1:
                    Item tmp = new Vase();
                    ((Vase)tmp).inputVase();
                    if(obj.addItem(tmp)) 
                        System.out.println("Added!");
                    break;   
                case 2:
                    tmp = new Statue();
                    ((Statue)tmp).inputStatue();
                    if(obj.addItem(tmp)) 
                        System.out.println("Added!");
                    break;
                case 3:
                    tmp = new Painting();
                    ((Painting)tmp).inputPainting();
                    if(obj.addItem(tmp)) 
                        System.out.println("Added!");
                    break;
                case 4:
                    obj.displayAll();
                    break;
                case 5:
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter creator to find item: ");
                    String creator = sc.nextLine();
                    obj.findItem(creator);
                    break;
                case 6:
                    sc = new Scanner(System.in);
                    System.out.print("Enter index of item to update: ");
                    int index = sc.nextInt();
                    obj.updateItem(index);
                    break;
                case 7:
                    sc = new Scanner(System.in);
                    System.out.print("Enter index of item to remove: ");
                    index = sc.nextInt();
                    obj.removeItem(index);
                    break;
                case 8:
                    obj.displayItemsByType("Vase");
                    break;
                case 9:
                    obj.sortItems();
                    break;
                default:
                    System.out.println("Exited!");
                    break;
            }
        } while(choice<=9);  
    }
}
