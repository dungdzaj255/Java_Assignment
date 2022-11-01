
/**
 *
 * @author dungd
 */
import java.util.*;
public class Book implements IBook {
    int id;
    String name;
    String publishDate;
    String author;
    String language;
    float averagePrice;
    
    public Book() {
        
    }
    public Book(int id, String name, String publishDate, String author, String language) {
        this.name = name;
        this.publishDate = publishDate;
        this.author = author;
        this.language = language;
    }
    
    @Override
    public void display() {
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Date of publication: "+publishDate);
        System.out.println("Author: "+author);
        System.out.println("Language: "+language);
        System.out.println("Average Price: "+averagePrice);
        System.out.println("-----------------------------------");
    }
    static int[] PriceList = new int[3]; 
    void calculate() {
        this.averagePrice = (PriceList[0]+PriceList[1]+PriceList[2])/PriceList.length;
    }
    
}
