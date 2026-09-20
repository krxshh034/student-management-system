package StudentManagementSystem.src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import StudentManagementSystem.display.disp;

public class CRUD {
    static String NAME;
    static int ROLL;
    static String CLASS;
    static String ADM;

    // TO ADD STUDENT RECORDS
    public static void input() {
        Scanner in = new Scanner(System.in);

        // Take input for the student details
        System.out.println("Enter the student name: ");
        NAME = in.nextLine();
        
        System.out.println("Enter the student roll number: ");
        ROLL = in.nextInt();
        in.nextLine(); // Consumes the leftover newline
        
        System.out.println("Enter the student class: ");
        CLASS = in.nextLine();
        
        System.out.println("Enter the student admission number: ");
        ADM = in.nextLine();

        try {
            // 1. Ensure the 'database' folder exists automatically
            Path dbDir = Paths.get("StudentManagementSystem/database");
            if (!Files.exists(dbDir)) {
                Files.createDirectories(dbDir);
            }

            // 2. Append data to each text file safely (creates files if they don't exist)
            Files.writeString(dbDir.resolve("names.txt"), NAME + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Files.writeString(dbDir.resolve("roll.txt"), ROLL + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Files.writeString(dbDir.resolve("sec.txt"), CLASS + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Files.writeString(dbDir.resolve("adm.txt"), ADM + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            return;
        } catch (IOException e) {
            System.out.println("An error occurred while saving the data.");
            e.printStackTrace();
        }

        in.close();
    }

        // TO REMOVE STUDENT RECORDS
        public static void remove() {
            
        // for input
        Scanner sc = new Scanner(System.in);
        
        //path declaration for the database folder and text files
        Path dbDir = Paths.get("StudentManagementSystem/database");
        Path nameFile = dbDir.resolve("names.txt");
        Path rollFile = dbDir.resolve("roll.txt");
        Path classFile = dbDir.resolve("sec.txt");
        Path admFile = dbDir.resolve("adm.txt");

        System.out.println("Enter the name of the student to remove record: ");
        String nameToRemove = sc.nextLine();

        try {
            // Read all lines from each file into separate lists
            java.util.List<String> names = Files.readAllLines(nameFile);
            java.util.List<String> roll = Files.readAllLines(rollFile);
            java.util.List<String> sec = Files.readAllLines(classFile);
            java.util.List<String> adms = Files.readAllLines(admFile);

            for (int i = 0; i<names.size(); i++) {
                if (names.get(i).equalsIgnoreCase(nameToRemove)) {
                    names.remove(i);
                    roll.remove(i);
                    sec.remove(i);
                    adms.remove(i);
                    Files.write(nameFile, names);
                    Files.write(rollFile, roll);
                    Files.write(classFile, sec);
                    Files.write(admFile, adms);
                    System.out.println("Desired student record has successfully been removed.");
                    break;
                }
            }
        } catch (Exception e) {
        System.out.println("An error occurred while searching for the student.");
        e.printStackTrace();
        }
        while (true) {
        disp.heavydivider();
        System.out.println("|| 1 : Remove Another Student Record || 2 : Return to Main Menu ||");
        disp.heavydivider();
        int choice = sc.nextInt();
        if (choice==1) {
        remove();
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












