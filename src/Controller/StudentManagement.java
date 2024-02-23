package Controller;

import View.*;

public class StudentManagement extends Menu<String>{
    StudentListC studentList = new StudentListC();
    public StudentManagement(String title, String[] mChon){
        super(title, mChon);
    }
    @Override
    public void execute(int n){
        switch(n){
            case 1: studentList.addStudent();
                    break;
            case 2:studentList.sortNFind();
                    break;
            case 3:studentList.updNDel();
                    break;
            case 4: studentList.report();
                    break;
            case 5: System.out.println("Goodbye!");
                    System.exit(0);
            default: System.out.println("Invalid choice!");
                    System.out.println("Please choose from the menu!");                                
        }
    }
    public static void main(String[] args) throws Exception {
        String[] mChon = {"Create", "Find and sort", "Update/Delete", "Report", "Exit"};
        StudentManagement studentManagement = new StudentManagement("Student Management", mChon);
        studentManagement.run();
    }
}
