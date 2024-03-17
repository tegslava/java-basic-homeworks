package org.example;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try (Socket socket = new Socket("localhost", 8081)) {
                System.out.println(socket.getInetAddress());
                System.out.println(socket.getLocalAddress());
                System.out.println(socket.getLocalPort());
                System.out.println(socket.isBound());
                System.out.println(socket.isConnected());
                ExampleClient client = new ExampleClient(socket.getInputStream(), socket.getOutputStream());
                System.out.println("Enter message:");
                String userMessage = scanner.nextLine();
                if (userMessage.equals("exit")) {
                    break;
                }
                client.send(userMessage);
            } catch(IOException e){
                throw new RuntimeException(e);
            }
        }
    }
}
