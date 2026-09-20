package StudentManagementSystem.display;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class disp {


    static String name = "|| \u001B[1mNAME:\u001B[0m";
    static String rn = "|| \u001B[1mROLL NO:\u001B[0m";
    static String csec = "|| \u001B[1mCLASS:\u001B[0m";
    static String adm = "|| \u001B[1mADMISSION NO:\u001B[0m";

    public static void divider() {
        System.out.println("--------------------------------------------------");
    }
    
    public static void heavydivider() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void choiceheader() {
        System.out.println("|| 1 : Add Student Record || 2 : Remove Student Record || 3 : Update Student Record || 4 : Search Student Record || 5 : Exit ||");
    }

    public static void studentdetails() {
        //path declaration for the database folder and text files
        Path dbDir = Paths.get("StudentManagementSystem/database");
        Path nameFile = dbDir.resolve("names.txt");
        Path rollFile = dbDir.resolve("roll.txt");
        Path classFile = dbDir.resolve("sec.txt");
        Path admFile = dbDir.resolve("adm.txt");

        try {
            // Check if the database folder or name file exists yet
            if (!Files.exists(nameFile)) {
                System.out.println("\nNo student records found yet!");
                return;
            }

        // Read all lines from each file into separate lists
            java.util.List<String> names = Files.readAllLines(nameFile);
            java.util.List<String> roll = Files.readAllLines(rollFile);
            java.util.List<String> sec = Files.readAllLines(classFile);
            java.util.List<String> adms = Files.readAllLines(admFile);

        // print the student details in a formatted table
        for (int i = 0; i < names.size(); i++) {
            System.out.println("\u001B[1m### STUDENT RECORD\u001B[0m " + (i + 1) + "\u001B[1m ###\u001B[0m");
            System.out.println(name + (i < names.size() ? names.get(i) : "N/A"));
            System.out.println(rn + (i < roll.size() ? roll.get(i) : "N/A"));
            System.out.println(csec + (i < sec.size() ? sec.get(i) : "N/A"));
            System.out.println(adm + (i < adms.size() ? adms.get(i) : "N/A") + "\n");
        }

        } catch (Exception e) {
            System.out.println("An error occurred while reading the student records.");
            e.printStackTrace();
        }

    }

}