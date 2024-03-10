package ru.tegneryadnov.java.basic.homeworks.homework12;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Класс для утилит чтения, записи текстовых файлов
 */
public class ReadWriteTextFiles {
    private static final int AttemptsFileSelect = 10;
    private static final int AttemptsFileEdit = 10;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Запрашивает у пользователя строку и добавляет ее в текстовый файл
     *
     * @param scanner
     * @param inputFileName
     * @return если пользователь отказался от редактирования, возвращает false
     */
    public static boolean appendLineToFile(Scanner scanner, String inputFileName) {
        boolean continueEdit = true;
        System.out.printf("Введите строку для добавления в файл. \"end\" - выход)\n", inputFileName);
        System.out.print(">");
        String inputLine = scanner.nextLine();
        if (inputLine.trim().equals("end")) {
            continueEdit = false;
            return continueEdit;
        }
        ReadWriteTextFiles.bufferedOutputStreamLineWriter(inputFileName, inputLine, true);
        return continueEdit;
    }

    /**
     * Выбор файла для обработки или выход
     *
     * @param scanner
     * @return true - продолжить
     */
    public static String selectFileName(Scanner scanner) {
        System.out.print("Введите имя файла для редактирования, (для выхода из программы введите \"end\"): ");
        String inputFileName = scanner.nextLine();
        return inputFileName;
    }

    /**
     * Выбор файла и добавление строки. Количество попыток редактирования ограничено
     * константами
     *     private static final int AttemptsFileSelect = 10;
     *     private static final int AttemptsFileEdit = 10;
     */
    public static void fileEdit() {
        try (Scanner scanner = new Scanner(System.in);) {
            int i = 0;
            for (; i < AttemptsFileSelect; i++) {
                System.out.printf("Выбор файла для редактирования. Попытка %d/%d\n", i + 1, AttemptsFileSelect);
                String fileName = selectFileName(scanner);
                if (fileName.equals("end")) {
                    break;
                }
                if (!(new File(fileName)).exists()) {
                    System.out.printf("Файл %s не найден.\n", fileName);
                    continue;
                }
                System.out.printf("Выбран файл \"%s\". Вывод на экран:\n", fileName);
                bufferedInputStreamReader(fileName);
                int j = 0;
                for (; j < AttemptsFileEdit; j++) {
                    System.out.printf("Добавление строки в файл \"%s\". Попытка %d/%d\n", fileName, j + 1, AttemptsFileEdit);
                    if (!appendLineToFile(scanner, fileName)) {
                        break;
                    }
                }
                if (j == AttemptsFileEdit) {
                    System.out.println("Исчерпано количество попыток редактирования файла");
                }
            }
            if (i == AttemptsFileSelect) {
                System.out.println("Исчерпано количество попыток выбора файла");
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

}