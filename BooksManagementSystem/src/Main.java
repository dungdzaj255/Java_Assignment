



import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dungd
 */
public class Main {
     public static void main(String[] args){
        String[] options={"Insert new book","View list of books","Average Price","Exit"};
        Book[] ArrayList = new Book[3];
        int choice=0;
        do {
            choice = Menu.getChoice(options);
            switch(choice) {
                case 1: 
                    
                    for (int i=0; i<3; i++) { 
                        int id=0;
                        System.out.println("\nInput information of book " +(i+1)+":");
                        Scanner sc = new Scanner(System.in);
                        System.out.print("Enter book name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter date of publication: ");
                        String publishDate = sc.nextLine();
                        System.out.print("Enter Author name: ");
                        String author = sc.nextLine();
                        System.out.print("Enter Language: ");
                        String language = sc.nextLine();
                        ArrayList[i] = new Book(id++, name, publishDate, author, language);
                    }
                    for (int i=0; i<3; i++) {
                        Scanner sc = new Scanner(System.in);
                        System.out.print("Enter price of book " +(i+1) + ": ");
                        Book.PriceList[i] = Integer.parseInt(sc.nextLine());
                    }
                    break;
                case 2:
                    for (int i=0; i<3; i++) {
                        System.out.print("Information of book " +(i+1) + ":\n");
                        ArrayList[i].display();
                    }
                    break;
                case 3:
                    for (int i=0; i<3; i++) {
                        ArrayList[i].calculate();
                    }
                    for (int i=0; i<3; i++) {
                        System.out.print("Information of book " +(i+1) + ":\n");
                        ArrayList[i].display();
                    }
                    break;
                default:
                    System.out.println("Program was shut down!");
                    break;
            }
        } while(choice<=3);
    }
}
