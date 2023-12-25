/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package server;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ASUS
 */
@WebService(serviceName = "WS935")
public class WS935 {

    @WebMethod(operationName = "readStudentInfo")
    public Boolean readStudentInfo(@WebParam(name = "studentInfo") String studentInfo) {
        String[] listStudentInfo = studentInfo.split("\\;");
        return listStudentInfo[1].equals("935");
    }

    @WebMethod(operationName = "getData")
    public String getData() {
        return "2208;123vo!@$%^huu097tuan";
    }

    @WebMethod(operationName = "confirmAnswer")
    public Boolean confirmAnswer(@WebParam(name = "answer") String answer) {
        return answer.equals("2208;vohutan");
    }
}
