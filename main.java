package StudentManagementSystem;

import StudentManagementSystem.display.disp;

import java.util.Scanner;

public class Main {

    @SuppressWarnings("resource")
    
    public static void main (String args [] ) 
    {
        
        while (true) {

        // divider display
        disp.heavydivider();
        
        // display of the student details
        disp.studentdetails();

        // heavy divider
        disp.heavydivider();

        // header display   
        disp.choiceheader();

        // divider display
        disp.heavydivider();

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
                StudentManagementSystem.display.search.searchStudent();
                break;
            case 5:
                return; // Exit the program
            default:
                System.out.println("Invalid choice. Please try again.");
            }

        }

    }
}