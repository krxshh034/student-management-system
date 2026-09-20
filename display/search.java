package StudentManagementSystem.display;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class search {

    public static void searchStudent() {


        // input for the name of the student to search
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the name of the student to search: ");
        String search_name = in.nextLine();

        //path declaration for the database folder and text files
        Path dbDir = Paths.get("StudentManagementSystem/database");
        Path nameFile = dbDir.resolve("names.txt");
        Path rollFile = dbDir.resolve("roll.txt");
        Path classFile = dbDir.resolve("sec.txt");
        Path admFile = dbDir.resolve("adm.txt");
    

    try {
        // Read all lines from each file into separate lists
            java.util.List<String> names = Files.readAllLines(nameFile);
            java.util.List<String> roll = Files.readAllLines(rollFile);
            java.util.List<String> sec = Files.readAllLines(classFile);
            java.util.List<String> adms = Files.readAllLines(admFile);

        for (int i = 0; i < names.size(); i++) {
            
            if (names.get(i).equalsIgnoreCase(search_name)) {
                disp.heavydivider();
                System.out.println("\u001B[1m### STUDENT RECORD\u001B[0m " + (i + 1) + "\u001B[1m ###\u001B[0m");
                System.out.println(disp.name + (i < names.size() ? names.get(i) : "N/A"));
                System.out.println(disp.rn + (i < roll.size() ? roll.get(i) : "N/A"));
                System.out.println(disp.csec + (i < sec.size() ? sec.get(i) : "N/A"));
                System.out.print(disp.adm + (i < adms.size() ? adms.get(i) : "N/A") + "\n");
            }
            
        }

    } catch (Exception e) {
        System.out.println("An error occurred while searching for the student.");
        e.printStackTrace();
    }

    while (true) {
    disp.heavydivider();
    System.out.println("|| 1 : Search Again || 2 : Return to Main Menu ||");
    disp.heavydivider();
    int choice = in.nextInt();
    if (choice==1) {
        searchStudent();
        break; }
    else if (choice==2){
        return;
    }
    else {
        System.out.println("Invalid choice. Returning to main menu.");
            return;
    }
    
    }
    
    }
}

