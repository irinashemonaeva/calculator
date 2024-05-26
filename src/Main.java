import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static String[] Roman = new String[] {
            null, "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };

    public static void main(String[] args) throws Exception{
        Main calculator = new Main();
        calculator.runCalculator();
    }

    public void runCalculator() throws Exception {
        int num1, num2, answer;
        String operator;
        //считываем информацию
        Scanner myObj = new Scanner(System.in);
        String input = myObj.nextLine();
        String[] parts = input.split(" ");
        operator = parts[1];
        if (parts.length>3) {
            throw new Exception("Неверный формат ввода");
        }
        boolean isRomanInput1 = isRoman(parts[0]);
        boolean isRomanInput2 = isRoman(parts[2]);
        if (isRomanInput1&&isRomanInput2) {
            num1 = romanToArabic(parts[0]);
            num2 = romanToArabic(parts[2]);
        } else {
            num1 = Integer.parseInt(parts[0]);
            num2 = Integer.parseInt(parts[2]);
        }
        if ((num1>10)||(num2>10)) {
            throw new Exception("Введите числа меньше или равные 10");
        }
        answer = calculate(num1, num2, parts[1], isRomanInput1);

        if (isRomanInput1) {
            System.out.println(arabicToRoman(answer));
        } else {
            System.out.println(answer);
        }
    }

    private boolean isRoman(String input) {
        List<String> romanList = Arrays.asList(Roman);
        return romanList.contains(input);
    }

    private int romanToArabic(String roman) {
        return Arrays.asList(Roman).indexOf(roman);
    }
    private int calculate(int num1, int num2, String operator, boolean isRoman) throws Exception {
        int answer;
        if (operator.equals("+")) {
            answer = num1 + num2;
        }
        else if (operator.equals("-")) {
            answer = num1 - num2;
        }
        else if (operator.equals("*")) {
            answer = num1 * num2;
        }
        else if (operator.equals("/")) {
            answer = num1 / num2;
        }
        else {
            throw new Exception("Неверный формат ввода");
        }
        return answer;
    }

    private String arabicToRoman(int answer) {
        return Roman[answer];
    }


}