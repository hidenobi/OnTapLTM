/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rmi2208;

import java.rmi.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author TuanVH
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        HandleStudent customStudent = (HandleStudent) Naming.lookup("rmi://localhost/custom");
        String request = customStudent.getNumber("B20DCCN622;2208");
        String[] li = request.split("\\;");
        String id = li[0];
        String l = li[1];
        String[] tmp = l.split("\\,");
        ArrayList<String> array = new ArrayList<>();
        array.addAll(Arrays.asList(tmp));
        Collections.sort(array, Collections.reverseOrder());
        String ans = id + ",";
        for (String a : array) {
            ans += a;
        }
        System.out.println(customStudent.greatestNumber(ans));
    }
    
}
