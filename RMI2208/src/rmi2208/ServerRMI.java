/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi2208;

import java.rmi.*;
/**
 *
 * @author TuanVH
 */
public class ServerRMI {
    public static void main(String[] args) throws Exception{
        CustomStudent customStudent = new CustomStudent();
        Naming.rebind("rmi://localhost/custom", customStudent);
    }
}