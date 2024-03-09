package ru.tegneryadnov.java.basic.homeworks.homework12_1;

import java.io.File;

/**
 * Класс со списком файлов текущего каталога.
 * fileType типа FileType используется для сортировки
 * Папки отображаются в угловых скобках
 */
public class FileInform {
    public final File file;
    public final FileType fileType;

    public FileInform(File file) {
        this.file = file;
        this.fileType = file.isDirectory() ? FileType.DIRECTORY : FileType.FILE;
    }

    @Override
    public String toString() {
        return fileType.equals(FileType.DIRECTORY) ? String.format("<%s>", file.getName()) : file.getName();
    }
}