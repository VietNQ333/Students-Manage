package Controller;

import Model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class StudentListC {
    ArrayList<Student> studentList = new ArrayList<>();

    public Student createStudent(){
        Student newStudent = new Student(null, null, null, 0);
        System.out.println("Enter ID: ");
        newStudent.setId(Validation.checkInputID());
        System.out.println("Enter name: ");
        newStudent.setName(Validation.checkInputString());
        System.out.println("Enter course: ");
        newStudent.setCourse(Validation.checkCourse());
        System.out.println("Enter semester: ");
        newStudent.setSemester(Validation.checkSemester(1, 9));
    
        return newStudent;
    }

    public void report(){
        Map<String, Integer> studentMap = new HashMap<>(); 
        for(Student student : studentList){
            String studentID = student.getId();
            studentMap.put(studentID, 1);
            if(studentMap.containsKey(studentID)){
                studentMap.put(studentID, studentMap.get(studentID) + 1);
            }
        }
        System.out.println("<>===<> Student List <>===<>");
        for(Map.Entry<String, Integer> entry : studentMap.entrySet()){
            String studentID = entry.getKey();
            for(Student student : studentList){
                if(student.getId().equals(studentID)){
                    System.out.println(student.getId() +" | " + student.getName() +" | " + student.getSemester() + " | total courses: " + entry.getValue());
                    break;
                }
            }
        }
    }

    public void addStudent(){
        int i = 0;
        while(true){
            System.out.println("Enter student number " + (i+ 1));
            studentList.add(createStudent());
            i++;
            if(i >= 9){
                System.out.println("Do you want to continue(Y/N):");
                if(!Validation.checkInputYN()){
                    report();
                    return;
                }    
            }
        }
    }

    public void sortNFind(){
        Collections.sort(studentList,new MyComparator());
        if(studentList.isEmpty()){
            System.out.println("Student list is empty!");
            return;
        }
        System.out.println("Enter the name of the student you want to find: ");
        String name = Validation.checkInputString();
        boolean found = false;
        for(Student student : studentList){
            if(student.getName().equalsIgnoreCase(name)){
                System.out.println(student);
                found = true;
            }
        }
        if(!found){
            System.out.println("Student not found!");
        }
    }


    public void updNDel(){
        if(studentList.isEmpty()){
            System.out.println("Student list is empty!");
            return;
        }
        System.out.println("Enter student's ID you want to update: ");
        String studentID = Validation.checkInputID();
        boolean found = false;
        for(Student student : studentList){
            
            if(student.getId().equalsIgnoreCase(studentID)){
                while(true){
                    System.out.println("Do you want to update or delete!(U/D)");
                    String result = Validation.checkInputString();
                    if(result.equalsIgnoreCase("U")){
                        while(true){
                            System.out.println("Do you want to update course or semester(C/S): ");
                            if(Validation.checkInputString().equalsIgnoreCase("C")){
                                System.out.println("Enter updated course: ");
                                student.setCourse(Validation.checkCourse());
                                return;
                            }else if(Validation.checkInputString().equalsIgnoreCase("S")){
                                System.out.println("Enter updated semester: ");
                                student.setSemester(Validation.checkSemester(1, 9));
                                return;
                            }else{
                                System.out.println("Not a choice!");
                                System.out.println("Enter again!");
                            }
                        }   
                    }else if(result.equalsIgnoreCase("D")){
                        studentList.remove(student);
                        System.out.println("Student removed!");
                        return;
                    }else{
                        System.out.println("Not a choice!");
                        System.out.println("Enter again!");
                    }
                }
            }  
            found = true;
        }
        if(!found){
            System.out.println("Student not found!");
        }    
  }
}