package ru.tegneryadnov.java.basic.homeworks.homework13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8081);
        while (true) {
            System.out.println("Старт сервера. Ожидание клиента...");
            Socket clientSocket = socket.accept();
            System.out.println("Клиент подключен.");
            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
            outputStream.writeUTF("Вы подключились к on-line калькулятору.\nДоступны математические операции: +,-,*,/");
            String userInput = inputStream.readUTF();
            System.out.println(userInput);
            String result = "Результат вычислений: " + Calculator.showResultOfExpression(userInput);
            System.out.println("Результат вычислений: " + result);
            outputStream.writeUTF(result);
            outputStream.flush();
        }
    }
}

