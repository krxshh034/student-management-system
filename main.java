package StudentManagementSystem;

import StudentManagementSystem.display.disp;
import java.util.Scanner;

public class Main {
    public static void main (String args [] ) 
    {

        // heavy divider
        disp.heavydivider();
        
        // header display   
        disp.choiceheader();

        // divider display
        disp.divider();

        // display of the student details
        disp.studentdetails();

        // divider display
        disp.divider();

        // input and assigning choice of the header to task
        Scanner in = new Scanner(System.in);
        int ch = in.nextInt();
    
        switch (ch) {
            case 1:
                StudentManagementSystem.src.CRUD.input();
                break;
            case 2:
                // Code for removing a student
                break;
            case 3:
                // Code for updating a student
                break;
            case 4:
                // Code for searching a student
                break;
            case 5:
                 // Exit the program
            default:
                System.out.println("Invalid choice. Please try again.");
        }








        
        
    }
}