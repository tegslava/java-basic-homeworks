package ru.tegneryadnov.java.basic.homeworks.homework13;

import java.io.*;

public class ExampleClient implements AutoCloseable {
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public ExampleClient(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = new DataInputStream(inputStream);
        this.outputStream = new DataOutputStream(outputStream);
    }

    public void send(String message) throws IOException {
        outputStream.writeUTF(message);
        outputStream.flush();
    }

    public void receive() throws IOException {
        String result = inputStream.readUTF();
        System.out.println(result);
    }

    @Override
    public void close() throws Exception {
        inputStream.close();
        outputStream.close();
    }
}
