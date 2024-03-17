package ru.tegneryadnov.java.basic.homeworks.homework13;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try (Socket socket = new Socket("localhost", 8081)) {
                ExampleClient client = new ExampleClient(socket.getInputStream(), socket.getOutputStream());
                client.receive();
                System.out.println("Для расчетов укажите: число1 операция число2 <Enter>:");
                System.out.println("Для выхода введите exit.");
                System.out.println("Введите выражение:");
                String userMessage = scanner.nextLine();
                if (userMessage.equals("exit")) {
                    break;
                }
                client.send(userMessage);
                client.receive();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}