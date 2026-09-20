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
        disp.heavydivider();
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
            in.close();
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
        disp.heavydivider();
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
                    disp.heavydivider();
                    System.out.println("Desired student record has successfully been removed.");
                    sc.close();
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
            disp.heavydivider();
        System.out.println("Invalid choice. Returning to main menu.");
            return;
    }
    
    }
}

    // TO UPDATE STUDENT RECORDS

    public static void update() {
    Scanner sc = new Scanner(System.in);
    
    // Path declaration for the database folder and text files
    Path dbDir = Paths.get("StudentManagementSystem/database");
    Path nameFile = dbDir.resolve("names.txt");
    Path rollFile = dbDir.resolve("roll.txt");
    Path classFile = dbDir.resolve("sec.txt");
    Path admFile = dbDir.resolve("adm.txt");

    // What do you need to change?
    disp.heavydivider();
    System.out.println("What in the record are you looking to change?");
    disp.heavydivider(); 
    System.out.println("|| 1 : Name || 2 : Roll No || 3 : Class || 4 : Admission No");
    disp.heavydivider();
    int choice = sc.nextInt();
    sc.nextLine(); // CONSUME THE LEFTOVER NEWLINE (Crucial fix!)

    try {
        switch (choice) {
            // UPDATE NAME
            case 1: {
                disp.heavydivider();
                System.out.println("Enter the name of the student to change record: ");
                String nameToChange = sc.nextLine();
                disp.heavydivider();
                System.out.println("What would you like to change it to: ");
                String changeInto = sc.nextLine();

                java.util.List<String> names = Files.readAllLines(nameFile);
                boolean found = false;

                for (int i = 0; i < names.size(); i++) {
                    if (names.get(i).equalsIgnoreCase(nameToChange)) {
                        names.set(i, changeInto);
                        found = true;
                        break;
                    }
                }

                if (found) {
                    Files.write(nameFile, names);
                    disp.heavydivider();
                    System.out.println("Name updated successfully!");
                } else {
                    disp.heavydivider();
                    System.out.println("Student name not found.");
                }
                break;
            }

            // UPDATE ROLL NUMBER
            case 2: {
                disp.heavydivider();
                System.out.print("Enter the name of the student to change record: ");
                String nameToSearch = sc.nextLine();
                disp.heavydivider();
                System.out.print("What would you like to change the roll number to: ");
                String newRoll = sc.nextLine();

                java.util.List<String> names = Files.readAllLines(nameFile);
                java.util.List<String> roll = Files.readAllLines(rollFile);
                int index = -1;

                // Find student index via names.txt
                for (int i = 0; i < names.size(); i++) {
                    if (names.get(i).equalsIgnoreCase(nameToSearch)) {
                        index = i;
                        break;
                    }
                }

                if (index != -1 && index < roll.size()) {
                    roll.set(index, newRoll);
                    Files.write(rollFile, roll);
                    disp.heavydivider();
                    System.out.println("Roll number updated successfully!");
                } else {
                    disp.heavydivider();
                    System.out.println("Student not found or roll record mismatch.");
                }
                break;
            }

            // UPDATE CLASS 
            case 3: {
                disp.heavydivider();
                System.out.print("Enter the name of the student to change record: ");
                String nameToSearch = sc.nextLine();
                disp.heavydivider();
                System.out.print("What would you like to change the class to: ");
                String newClass = sc.nextLine();

                java.util.List<String> names = Files.readAllLines(nameFile);
                java.util.List<String> sec = Files.readAllLines(classFile);
                int index = -1;

                for (int i = 0; i < names.size(); i++) {
                    if (names.get(i).equalsIgnoreCase(nameToSearch)) {
                        index = i;
                        break;
                    }
                }

                if (index != -1 && index < sec.size()) {
                    sec.set(index, newClass);
                    Files.write(classFile, sec);
                    disp.heavydivider();
                    System.out.println("Class updated successfully!");
                } else {
                    disp.heavydivider();
                    System.out.println("Student not found or class record mismatch.");
                }
                break;
            }

            // UPDATE ADMISSION NUMBER
            case 4: {
                disp.heavydivider();
                System.out.print("Enter the name of the student to change record: ");
                String nameToSearch = sc.nextLine();
                disp.heavydivider();
                System.out.print("What would you like to change the admission number to: ");
                String newAdm = sc.nextLine();

                java.util.List<String> names = Files.readAllLines(nameFile);
                java.util.List<String> adms = Files.readAllLines(admFile);
                int index = -1;

                for (int i = 0; i < names.size(); i++) {
                    if (names.get(i).equalsIgnoreCase(nameToSearch)) {
                        index = i;
                        break;
                    }
                }

                if (index != -1 && index < adms.size()) {
                    adms.set(index, newAdm);
                    Files.write(admFile, adms);
                    disp.heavydivider();
                    System.out.println("Admission number updated successfully!");
                } else {
                    disp.heavydivider();
                    System.out.println("Student not found or admission record mismatch.");
                }
                break;
            }
            
            default:
                disp.heavydivider();
                System.out.println("Invalid choice selected.");
        }
        sc.close();
    } catch (Exception e) {
        System.out.println("An error occurred while updating the student record.");
        e.printStackTrace();
    }
}
    }


    

    












