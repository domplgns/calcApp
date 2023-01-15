package com.example.calcapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.Scanner;

public class CalcController {
    public static void getCalculation(String[] args) {
        System.out.println("Введите выражение (стоп - остановить программу)");
        Scanner scanner = new Scanner(System.in); //Считывание данных//
        do{
            String firstArgument = "";
            String secondArgument = "";
            String action = "";
            double result = -100000;
            int flag = 0;
            String input = scanner.nextLine(); //Перенос на новую строку//
            input = input.trim(); //Удаление пробелов из строки//
            if (input.equals("стоп")) break;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) != ' ' && flag == 0) {
                    try {
                        Double checkFormat = Double.parseDouble(String.valueOf(input.charAt(i)));
                    } catch (NumberFormatException e){
                        if(input.charAt(i) != '.'){
                            i--;
                            flag++;
                            continue;
                        }
                    }
                    firstArgument += input.charAt(i);
                    continue;
                }
                if (input.charAt(i) == ' ') {
                    continue;
                }
                if (input.charAt(i) != ' ' && flag == 1) {
                    action += input.charAt(i);
                    flag++;
                    continue;
                }
                if (input.charAt(i) != ' ' && flag == 2) {
                    secondArgument += input.charAt(i);
                    continue;
                }
            }
            double firstDouble = Double.parseDouble(firstArgument);
            double secondDouble = Double.parseDouble(secondArgument);

            System.out.println("Ответ: " + operation(firstDouble, secondDouble, action));
        }
        while(true);
    }

    private static double operation(double firstArgument, double secondArgument, String action) {
        return switch (action) {
            case "+" -> firstArgument + secondArgument;
            case  "-" -> firstArgument - secondArgument;
            case "*" -> firstArgument * secondArgument;
            case "/" -> firstArgument / secondArgument;
            case "%" -> firstArgument % secondArgument;
            default -> 0;
        };
    }
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}