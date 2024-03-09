package ru.tegneryadnov.java.basic.homeworks.homework12_1;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadWriteTextFiles {
    /**
     * Запись в файл строкового массива
     *
     * @param fileName имя файла
     * @param lines    cтроковый массив для записи
     * @param append   добавлять новыйе строки или перезаписывать файл
     */
    public static void bufferedOutputStreamArrWriter(String fileName, String[] lines, boolean append) {
        if ((fileName == null) || (fileName.isEmpty())) {
            throw new IllegalArgumentException("fileName must not be null or empty!");
        }
        if ((lines == null) || lines.length == 0) {
            throw new IllegalArgumentException("array lines must not be null or empty!");
        }
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName, append))) {
            for (String line : lines) {
                byte[] buffer = (line + "\n").getBytes(StandardCharsets.UTF_8);
                for (int i = 0; i < buffer.length; i++) {
                    out.write(buffer[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Запись в файл строки
     *
     * @param fileName имя файла
     * @param line     cтрока для записи
     * @param append   добавлять новыйе строки или перезаписывать файл
     */
    public static void bufferedOutputStreamLineWriter(String fileName, String line, boolean append) {
        bufferedOutputStreamArrWriter(fileName, new String[]{line}, append);
    }

    /**
     * Чтение текстового файла через InputStreamReader
     *
     * @param fileName имя перечитываемого текстового файла
     */
    public static void bufferedInputStreamReader(String fileName) {
        if ((fileName == null) || (fileName.isEmpty())) {
            throw new IllegalArgumentException("fileName must not be null or empty!");
        }
        try (var fis = new FileInputStream(fileName);
             var bis = new BufferedInputStream(fis);
             var in = new InputStreamReader(bis);) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}