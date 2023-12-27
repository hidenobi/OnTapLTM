/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package upd2208;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

/**
 *
 * @author ASUS
 */
public class Main {

    public static int port = 2208;
    public static String address = "localhost";

    public static void send(DatagramSocket socket, String request) throws Exception {
        InetAddress inetAddress = InetAddress.getByName(Main.address);
        byte[] bytes = request.getBytes();
        DatagramPacket sendPackage = new DatagramPacket(bytes, bytes.length, inetAddress, port);
        socket.send(sendPackage);
    }

    public static String receive(DatagramSocket socket) throws Exception{
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        socket.receive(datagramPacket);
        return new String(datagramPacket.getData());
    }

    public static void main(String[] args) throws Exception {
        String request = ";B20DCCN535;932";
        DatagramSocket socket = new DatagramSocket();
        send(socket, request);
        String receiveMsg = receive(socket);
        System.out.println(receiveMsg);
        String requestId = receiveMsg.split(";")[0];
        String data = receiveMsg.split(";")[1];
        data = String.join(",", Arrays.stream(data.split("\\s")).map(it -> it.substring(0, 1).toUpperCase() + it.substring(1).toLowerCase()).toList());
        send(socket, requestId + ";" + data);
    }

}
