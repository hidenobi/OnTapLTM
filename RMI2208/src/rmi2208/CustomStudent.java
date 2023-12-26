/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi2208;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.rmi.server.*;

/**
 *
 * @author TuanVH
 */
public class CustomStudent extends UnicastRemoteObject implements HandleStudent {

    public CustomStudent() throws Exception {
        super();
    }

    private final String list = generateRandomNumbers(100, 1000, 1000000);

    @Override
    public String getNumber(String studentInfo) throws RemoteException {
        System.out.println(studentInfo);
        String Id = "50000";
        return Id + ";" + list;
    }

    @Override
    public Boolean greatestNumber(String answer) throws RemoteException {
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
