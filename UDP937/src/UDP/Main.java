/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author TuanVH
 */
public class Main {

    public static int port = 2209;
    public static String address = "localhost";

    public static void main(String[] args) throws Exception {
        System.out.println("Client is running");
        Product937 product937 = new Product937("B20DCCN622");
        DatagramSocket socket = new DatagramSocket();
        send(socket, product937);
        product937 = (Product937) receive(socket);
        System.out.println(product937);
        product937.name = "937 thinkpad Lenovo";
        product937.quantity = 9511;
        send(socket, product937);
    }

    private static void send(DatagramSocket socket, Object request) throws Exception {
        InetAddress addressServer = InetAddress.getByName(Main.address);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(request);
        byte[] sendData = byteArrayOutputStream.toByteArray();
        socket.send(new java.net.DatagramPacket(sendData, sendData.length, addressServer, port));
    }

    private static Object receive(DatagramSocket socket) throws Exception {
        byte[] buffer = new byte[1024];
        java.net.DatagramPacket packet = new java.net.DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packet.getData(), 0, packet.getLength());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Product937 product937 = (Product937) objectInputStream.readObject();
        return product937;
    }

}
