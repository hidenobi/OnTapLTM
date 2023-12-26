/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author TuanVH
 */
public class UdpServer {

    public static void main(String[] args) throws Exception {
        DatagramSocket server = new DatagramSocket(2209);
        System.out.println("Server is running");
        while (true) {
            byte[] data = new byte[2048];
            DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
            server.receive(datagramPacket);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(datagramPacket.getData(), 0, datagramPacket.getLength());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Product937 product937 = (Product937) objectInputStream.readObject();
            System.out.println(product937.toString());
            // set new data
            product937.id = "Product937";
            product937.name = "Lenovo thinkpad 937";
            product937.quantity = 1159;
            // send a object
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(product937);
            byte[] sendData = byteArrayOutputStream.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, datagramPacket.getAddress(), datagramPacket.getPort());
            server.send(sendPacket);
            // answer data
            Product937 answer = product937;
            answer.name = "937 thinkpad Lenovo";
            answer.quantity = 9511;

            //receive data again
            datagramPacket = new DatagramPacket(data, data.length);
            server.receive(datagramPacket);
            byteArrayInputStream = new ByteArrayInputStream(datagramPacket.getData(), 0, datagramPacket.getLength());
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            product937 = (Product937) objectInputStream.readObject();
            System.out.println(product937.toString());
            System.out.println(product937.equals(answer));
        }
    }

}
