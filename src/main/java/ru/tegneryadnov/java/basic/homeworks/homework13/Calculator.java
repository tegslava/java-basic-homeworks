package ru.tegneryadnov.java.basic.homeworks.homework13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static double calc(String[] userInput) throws NumberFormatException {
        double num1 = Double.parseDouble(userInput[0]);
        double num2 = Double.parseDouble(userInput[2]);
        String operation = userInput[1];
        Double result = 0d;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
        }
        return result;
    }

    private static String[] parsingUserInput(String input) {
        String[] allMatches = new String[3];
        String regex = "^(\\d+[.,]?\\d*)([+\\-*/])(\\d+[.,]?\\d*)$";
        Matcher m = Pattern.compile(regex).matcher(input);
        if (m.find()) {
            allMatches[0] = m.group(1);
            allMatches[1] = m.group(2);
            allMatches[2] = m.group(3);
        }
        return allMatches;
    }

    public static String showResultOfExpression(String userInput) throws NumberFormatException {
        String[] expression = parsingUserInput(userInput);
        return String.format("%.4f%s%.4f=%.4f",
                Double.parseDouble(expression[0]),
                expression[1],
                Double.parseDouble(expression[2]),
                calc(expression));
    }

    public static void main(String[] args) {
        System.out.println(showResultOfExpression("1.23+1.3"));
    }
}