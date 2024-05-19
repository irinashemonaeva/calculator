//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) throws Exception{
        int num1, num2, answer, type; // type: 0 - arabic, 1 - roman
        String operator;
        num1 = 0;
        //считываем информацию
        Scanner myObj = new Scanner(System.in);
        String input = myObj.nextLine();
        String[] Roman = new String[] {null, "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};
        String[] parts = input.split(" ");
        operator = parts[1];
        boolean isRoman1, isRoman2;
        if (parts.length>3) {
            throw new Exception("Неверный формат ввода");
        }
        List<String> romanList = Arrays.asList(Roman);
        num1 = romanList.indexOf(parts[0]);
        num2 = romanList.indexOf(parts[2]);
        if ((num1>0)&&(num2>0)&&(num1<=10)&&(num2<=10)) {
            if (operator.equals("+")) {
                answer = num1 + num2;
                System.out.println(Roman[answer]);
            }
            else if (operator.equals("-")) {
                answer = num1 - num2;
                System.out.println(Roman[answer]);
            }
            else if (operator.equals("*")) {
                answer = num1 * num2;
                System.out.println(Roman[answer]);
            }
            else if (operator.equals("/")) {
                answer = num1 / num2;
                System.out.println(Roman[answer]);
            }
        } else {
            num1 = Integer.valueOf(parts[0]);
            num2 = Integer.valueOf(parts[2]);
            if ((num1>10)|(num2>10)) {
                throw new Exception("Введите числа меньше 10.");
            }
            else if (operator.equals("+")) {
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
            System.out.println(answer);
        }

    }
}