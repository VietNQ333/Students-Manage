package Controller;

import java.util.Scanner;

public class Validation {
    private final static Scanner in = new Scanner(System.in);
    private final static String idReg = "^[A-Za-z]{2}\\d{6}$";
    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static String checkInputID(){
        while(true){
            String result = checkInputString();
            if(result.matches(idReg)){
                return result;
            }else{
                System.out.println("Wrong format(ccdddddd): ");
                System.out.println("Please enter again");
            }
        }
    }


    public static String checkCourse(){
        while(true){
            String result = checkInputString();
            if(result.equalsIgnoreCase(".NET"))
                return ".NET";
            if(result.equalsIgnoreCase("Java"))
                return "Java";
            if(result.equalsIgnoreCase("C/C++"))
                return "C/C++";
            System.out.println("Invalid input, please choose in one of the three courses(.NET, Java, C/C++). ");
            System.out.println("Enter again: ");
        }
    }

    public static int checkSemester(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input semester in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }


    public static boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //check user input y/Y or n/N
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }


}
