import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        calculate(line);
        scanner.close();

    }

    static void calculate(String line) throws Exception {
        String[] stringArray = line.split(" ");
        if (stringArray.length > 3)
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        if (stringArray.length < 3)
            throw new Exception("Cтрока не является математической операцией");
        String element1 = stringArray[0];
        String element2 = stringArray[2];

        if ((!RomanNumbers.isRoman(stringArray[0])) || (!RomanNumbers.isRoman(stringArray[2]))) {
            if ((RomanNumbers.isRoman(stringArray[0])) || (RomanNumbers.isRoman(stringArray[2])))
                throw new Exception("Используются одновременно разные системы счисления");
        }

        int number1;
        boolean romanOrNot1 = !element1.contains("I") && !element1.contains("V") && !element1.contains("X");

        if (!romanOrNot1) {
            number1 = (RomanNumbers.toArabian(element1));
        } else {
            number1 = Integer.parseInt(stringArray[0]);
        }
        if (number1 < 1 || number1 > 10) throw new Exception("Неверное число: (от 1 до 10 включительно)");


        int number2;
        boolean romanOrNot2 = !element2.contains("I") && !element2.contains("V") && !element2.contains("X");

        if (!romanOrNot2) {
            number2 = (RomanNumbers.toArabian(element2));
        } else {
            number2 = Integer.parseInt(stringArray[2]);
        }
        if (number2 < 1 || number2 > 10) throw new Exception("Неверное число: (от 1 до 10 включительно)");


        if (line.indexOf("+") >= 2) {
            if (romanOrNot1) {
                System.out.println((number1 + number2));
            } else {
                System.out.println(RomanNumbers.toRoman(number1 + number2));
            }
        } else if (line.indexOf("-") >= 2) {
            if (romanOrNot1) {
                System.out.println((number1 - number2));
            } else if ((number1 - number2) <= 0) {
                throw new Exception("В римской системе нет отрицательных чисел и нуля");
            } else {
                System.out.println(RomanNumbers.toRoman(number1 - number2));
            }
        } else if (line.indexOf("*") >= 2) {
            if (romanOrNot1) {
                System.out.println((number1 * number2));
            } else {
                System.out.println(RomanNumbers.toRoman(number1 * number2));
            }

        } else if (line.indexOf("/") >= 2) {
            if (romanOrNot1) {
                System.out.println((number1 / number2));
            } else if ((number1 - number2) <= 0) {
                throw new Exception("В римской системе нет отрицательных чисел и нуля");
            } else {
                System.out.println(RomanNumbers.toRoman(number1 / number2));
            }
        } else {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

    }


    static class RomanNumbers {
        static String[] numbersArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        static int toArabian(String roman) {
            for (int i = 0; i < numbersArray.length; i++) {
                if (roman.equals(numbersArray[i])) {
                    return i;
                }
            }
            return -1;
        }

        static String toRoman(int arabian) {
            return numbersArray[arabian];
        }

        static boolean isRoman(String val) {
            for (String s : numbersArray) {
                if (val.equals(s)) {
                    return true;
                }
            }
            return false;
        }

    }
}