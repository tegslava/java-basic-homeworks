package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static final List<ClientHandler> clientHandlers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8081);
        while(true) {
            System.out.println("Ожидаю socket:");
            Socket clientSocket = socket.accept();
            System.out.println("Получен socket:");
            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
            ClientHandler clientHandler = new ClientHandler(clientSocket, inputStream, outputStream);
            clientHandlers.add(clientHandler);
            System.out.println("Ожидаю ввода:");
            String userInput = inputStream.readUTF();
            System.out.println(userInput);
            String result = transform(userInput);
            outputStream.writeUTF(result);
            outputStream.flush();
            //System.out.println(result);
            System.out.println(clientHandlers.size());
        }
    }

    public static String transform(String input) {
        return input.toUpperCase();
    }
}
