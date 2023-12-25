/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author ASUS
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        demo.WS961_Service service = new demo.WS961_Service();
        demo.WS961 port = service.getWS961Port();
        String request = port.getNumber("B20DCCN622");
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
        System.out.println(port.greatestNumber(ans));
    }

}
