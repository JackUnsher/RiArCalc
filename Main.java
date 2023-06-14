import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static void main (String[] args) throws IOException {
        System.out.println("Введите выражение:");
        String innum = scanner.nextLine();

        char[] under_char = new char[10];
        for (int i = 0; i < innum.length(); i++) {
            under_char[i] = innum.charAt(i);
            if (innum.length() <= 2) {
                throw new IOException("Неверный ввод данных!");
            }
            if (under_char[i] == '+') {
                operation = '+';
                if (i > 2) {
                    throw new IOException("Неверный ввод данных!");
                }
            }
            if (under_char[i] == '-') {
                operation = '-';
                if (i > 2) {
                    throw new IOException("Неверный ввод данных!");
                }

            }
            if (under_char[i] == '*') {
                operation = '*';
                if (i > 2) {
                    throw new IOException("Неверный ввод данных!");
                }
            }
            if (under_char[i] == '/') {
                operation = '/';
                if (i > 2) {
                    throw new IOException("Неверный ввод данных!");
                }
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] ho = under_charString.split("[+-/*]");
        String stable00 = ho[0];
        stable00 = stable00.trim();
        String stable01 = ho[1];
        stable01 = stable01.trim();

        number1 = romanToNumber(stable00);
        number2 = romanToNumber(stable01);
        if (number1 >= 0){
            if (!(number2 >= 0)){
                throw new InputMismatchException("Разный тип данных, повторите попытку");
            }
        }
        if (number2 >= 0){
            if (!(number1 >= 0)){
                throw new InputMismatchException("Разный тип данных, повторите попытку");
            }
        }
        if (number1 < 0 && number2 < 0) {
            result = 0;
        } else {
            result = calculated(number1, number2, operation);
            String resultRoman = convertNumToRoman(result);
            System.out.println("Результат: " + resultRoman);
        }
        number1 = Integer.parseInt(stable00);
        number2 = Integer.parseInt(stable01);
        if (number1 < 0 || number1 > 10 || number2 < 0 || number2 > 10) {
            throw new IOException();
        }

        result = calculated(number1, number2, operation);
        System.out.println("Результат: " + result);
    }

    static String convertNumToRoman (int numArabian) {
        RimeNumber[] roman = RimeNumber.values();
        final String s = String.valueOf(roman[numArabian]);
        return s;
    }


    static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }

    static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException();
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}