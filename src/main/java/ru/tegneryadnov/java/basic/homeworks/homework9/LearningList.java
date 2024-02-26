package ru.tegneryadnov.java.basic.homeworks.homework9;

import java.util.ArrayList;

public class LearningList {

    public ArrayList getSequenceList(int min, int max, int step) {
        ArrayList list = new ArrayList<Integer>();
        for (int i = max; i >= min; i += step) {
            list.add(i);
        }
        return list;
    }

    public long getSumOfListElements(ArrayList<Integer> inputList, int trashHold) {
        if (inputList == null) throw new IllegalArgumentException("Ожидался список целых чисел!");
        long sumOfListElements = 0;
        for (int i : inputList) if (i > trashHold) sumOfListElements += i;
        return sumOfListElements;
    }

}
