package ru.tegneryadnov.java.basic.homeworks.homework12;

public class FileInform {
    public FileType fileType;
    public String fullName;

    public FileInform(String fullName, FileType fileType) {
        this.fullName = fullName;
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return fileType == FileType.DIRECTORY ? String.format("[%s]", fullName) : fullName;
    }
}
