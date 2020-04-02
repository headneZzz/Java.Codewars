package kyu3;


import java.util.*;

/**
 * Create a simple calculator that given a string of operators (), +, -, *, / and numbers
 * separated by spaces returns the value of that expression
 * Example:
 * Calculator.evaluate("2 / 2 + 3 * 4 - 6") // => 7
 * Remember about the order of operations! Multiplications and divisions have a higher priority and should be
 * performed left-to-right. Additions and subtractions have a lower priority and should also be performed left-to-right.
 */
public class Calculator {
    public static Double evaluate(String expression) {
        System.out.println(expression);
        expression = expression.replace(" ", "");
        Stack<Double> values = new Stack<>();
        char operator = '+';
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                int startIndex = i;
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.' || expression.charAt(i) == 'E'))
                    i++;
                i--;
                double temp = Double.parseDouble(expression.substring(startIndex, i + 1));
                System.out.println(temp);
                switch (operator) {
                    case ('+'):
                        values.push(temp);
                        break;
                    case ('-'):
                        values.push(-temp);
                        break;
                    case ('*'):
                        values.push(values.pop() * temp);
                        break;
                    default:
                        values.push(values.pop() / temp);
                        break;
                }
            } else {
                operator = expression.charAt(i);
            }
        }
        return values.stream().reduce(.0, Double::sum);
    }
}
