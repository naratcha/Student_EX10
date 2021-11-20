/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package studentservice;

import static java.lang.System.out;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import studentmodel.Student;
import studentmodel.StudentTable;

/**
 *
 * @author naratcha.s
 */
@WebService(serviceName = "StudentWebService")
public class StudentWebService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findStudentById")
    public Student findStudentById(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        return StudentTable.findStudentById(id);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertStudent")
    @Oneway
    public void insertStudent(@WebParam(name = "name") String name, @WebParam(name = "gpa") double gpa) {
        Student stu = new Student();
        stu.setName(name);
        stu.setGpa(gpa);
        StudentTable.insertStudent(stu);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateStudent")
    public boolean updateStudent(@WebParam(name = "id") int id, @WebParam(name = "name") String name, @WebParam(name = "gpa") double gpa) {
        Student stu = StudentTable.findStudentById(id);
        if (stu != null) {
            stu.setName(name);
            stu.setGpa(gpa);
            StudentTable.updateStudent(stu);
            return true;
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "removeStudent")
    public boolean removeStudent(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        Student stu = StudentTable.findStudentById(id);
        if (stu != null) {
            StudentTable.removeStudent(stu);
            return true;
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findAllStudent")
    public List<Student> findAllStudent() {
        //TODO write your implementation code here:
        return StudentTable.findAllStudent();
    }
    
    
    
    
    
    

    /**
     * This is a sample web service operation
     */
    
}
