/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ASUS
 */
@WebService(serviceName = "WS961")
public class WS961 {

    private final String list = generateRandomNumbers(100, 1000, 1000000);

    @WebMethod(operationName = "getNumber")
    public String getNumber(@WebParam(name = "studentInfo") String studentInfo) {
        System.out.println(studentInfo);
        String Id = "50000";
        return Id + ";" + list;

    }

    @WebMethod(operationName = "greatestNumber")
    public Boolean greatestNumber(@WebParam(name = "answer") String answer) {
        String[] l = answer.split("\\,");
        if (l[0].equals("50000")) {
            System.out.println("Id is correct");
        }
        String li = l[1];
        String[] tmp = list.split("\\,");
        ArrayList<String> array = new ArrayList<>();
        array.addAll(Arrays.asList(tmp));
        Collections.sort(array, Collections.reverseOrder());
        String ans = "";
        for (String a : array) {
            ans += a;
        }

        return ans.equals(li);
    }

    private static String generateRandomNumbers(int count, int min, int max) {
        if (count <= 0 || min > max) {
            return "Invalid parameters";
        }

        Random random = new Random();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {
            int randomNumber = random.nextInt((max - min) + 1) + min;
            result.append(randomNumber);

            if (i < count - 1) {
                result.append(",");
            }
        }

        return result.toString();
    }
}
