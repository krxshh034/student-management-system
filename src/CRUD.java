package StudentManagementSystem.src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class CRUD {
    static String NAME;
    static int ROLL;
    static String CLASS;
    static String ADM;

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

            System.out.println("New student data saved successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred while saving the data.");
            e.printStackTrace();
        }
    }
}