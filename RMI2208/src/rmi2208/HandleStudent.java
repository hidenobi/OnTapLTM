/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rmi2208;

import java.rmi.*;

/**
 *
 * @author TuanVH
 */
public interface HandleStudent extends Remote {

    public String getNumber(String studentInfo) throws RemoteException;

    public Boolean greatestNumber(String answer) throws RemoteException;
}
