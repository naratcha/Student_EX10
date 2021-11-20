/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentex10client;

import StudentWebService.Student;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author naratcha.s
 */
public class StudentEX10Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("---------- Student DBS Program (SOAP) ----------");
        System.out.println("1 - Insert Mode");
        System.out.println("2 - Update Mode");
        System.out.println("3 - Delete Mode");
        System.out.println("0 - Exit Mode");
        System.out.print("Please select menu : ");
        int menu = sc.nextInt();
        while (menu != 0) {
            System.out.println("------------------------------------------------");
            if (menu == 1) {
                System.out.println("Insert Mode has been selected.");
                System.out.println("------------------------------------------------");
                System.out.print("Please input Name : ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Please input GPA : ");
                double gpa = sc.nextDouble();
                InsertClient(name, gpa);
            }
            
            if (menu == 2) {
                System.out.println("Update Mode has been selected.");
                System.out.println("------------------------------------------------");
                List<Student> StudentList = findAllClient();
                if (StudentList.size() > 0) {
                    for (Student stu : StudentList) {
                        System.out.print(stu.getId() + " ");
                        System.out.print(stu.getName() + " ");
                        System.out.print(stu.getGpa() + " ");
                        System.out.println();
                    }
                    System.out.println("------------------------------------------------");
                    System.out.print("Please input ID : ");
                    int id = sc.nextInt();
                    System.out.print("Please input Name : ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Please input GPA : ");
                    double gpa = sc.nextDouble();
                    if (UpdateClient(id, name, gpa)) {
                        System.out.println("Update Completed");
                    }
                    else {
                        System.out.println("Update Failed");
                    }
                    
                } 
                else {
                    System.out.println("Information not found.");
                }  
            }
            
            if (menu == 3) {
                System.out.println("Delete Mode has been selected.");
                System.out.println("------------------------------------------------");
                List<Student> StudentList = findAllClient();
                if (StudentList.size() > 0) {
                    for (Student stu : StudentList) {
                        System.out.print(stu.getId() + " ");
                        System.out.print(stu.getName() + " ");
                        System.out.print(stu.getGpa() + " ");
                        System.out.println();
                    }
                    System.out.println("------------------------------------------------");
                    System.out.print("Please input ID : ");
                    int id = sc.nextInt();
                    if (RemoveClient(id)) {
                        System.out.println("Remove Completed");
                    }
                    else {
                        System.out.println("Remove Failed");
                    }
                    
                } 
                else {
                    System.out.println("Information not found.");
                }  
            }
            System.out.println("---------- Student DBS Program (SOAP) ----------");
            System.out.println("1 - Insert Mode");
            System.out.println("2 - Update Mode");
            System.out.println("3 - Delete Mode");
            System.out.println("0 - Exit Mode");
            System.out.print("Please select menu : ");
            menu = sc.nextInt();
        }
    }
    
    private static Student findByIDClient(int id) {
        StudentWebService.StudentWebService_Service service = new StudentWebService.StudentWebService_Service();
        StudentWebService.StudentWebService port = service.getStudentWebServicePort();
        return port.findStudentById(id);
    }
    
    private static List<Student> findAllClient() {
        StudentWebService.StudentWebService_Service service = new StudentWebService.StudentWebService_Service();
        StudentWebService.StudentWebService port = service.getStudentWebServicePort();
        return port.findAllStudent();
    }
    
    private static void InsertClient(String name, double gpa) {
        StudentWebService.StudentWebService_Service service = new StudentWebService.StudentWebService_Service();
        StudentWebService.StudentWebService port = service.getStudentWebServicePort();
        port.insertStudent(name, gpa);
    }
    
    private static boolean UpdateClient(int id, String name, double gpa) {
        StudentWebService.StudentWebService_Service service = new StudentWebService.StudentWebService_Service();
        StudentWebService.StudentWebService port = service.getStudentWebServicePort();
        return port.updateStudent(id, name, gpa);
    }
    
    private static boolean RemoveClient(int id) {
        StudentWebService.StudentWebService_Service service = new StudentWebService.StudentWebService_Service();
        StudentWebService.StudentWebService port = service.getStudentWebServicePort();
        return port.removeStudent(id);
    }
}
