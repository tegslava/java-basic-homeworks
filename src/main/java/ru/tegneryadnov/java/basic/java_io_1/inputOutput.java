package ru.tegneryadnov.java.basic.java_io_1;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class inputOutput {
    public static void main(String[] args) {

    }

    /**
     * Чтение файла через BufferedInputStream
     * @param fileName
     */
    /*● Обернули FileInputStream в BufferedInputStream
    ● Казалосþ бы побайтовое чтение должно бытþ медленным, но на
    самом деле это не так
    ● При первом чтении BufferedInputStream вычитывает из файла
    кусок в 8192 байта (или меньше, в зависимости от размера
    файла), и с каждýм read() выдает байт из внутреннего массива
    ● Размер внутреннего буфера можно регулировать
    * */
    public static void byteBufferedInputStream(String fileName){
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName))) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char)n);
                n = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Чтение текстового файла через InputStreamReader
     * @param fileName имя перечитываемого текстового файла
     */
    public static void inputStreamReader(String fileName) {
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(fileName))) {
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
     * Побайтовая запись в файл
     * @param fileName имя записываемого файла
     */
    public static void byteWriterFileOutputStream(String fileName) {
        String data = "Hello World";
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Запись в файл череза массив байтов
     * @param fileName имя записываемого файла
     */
    /*Можно сразу весþ байтовýй массив отправлять в поток
      Хорошая производительность
    */
    public static void byteArrayWriterFileOutputStream(String fileName){
        String data = "Hello World";
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
            out.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param fileName
     */

    /*Идея та же что и с буферизованным чтением. Внутри
    BufferedOutputStream хранитсā байтовый массив (буфер), куда на
    самом деле и пишутсā последователþно байтЫ
    ● Как толþко внутренний буфер заполняетсā (по-умолчанию его
    размер составляет - 8192), он выполняет запись в файл
    ● Если вы запишете в буфер, например, 3000 байт и потом
    программа упадет, то эти даннýе могут не попасть в точку
    назначения
    ● Метод flush() позволāет “вытолкнуть” данные из буфера в точку
    назначения
    * */
    public static void bufferedWriterBufferedOutputStream(String fileName){
        String data = "Hello World";
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName))) {
            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
