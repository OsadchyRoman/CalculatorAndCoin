package task_3.com.epam.training.inner.bean.calculator;

import java.util.*;

/**
 * The {@code Calculator} class represents calculator.
 * Need for calculate expression such as {@code "(1/(1+8)*9)"}.
 * Supports such operations as {@code +()/*-}.
 * His work is based on reverse Polish notation.
 *
 * @version 2.1
 * @autor Asadchy Raman
 */

public class Calculator {
    /**
     * The operations supported by the calculator
     */
    private final static String OPERATORS = "+-*/";

    /**
     * Implementation of the algorithm revers Polish notation.
     *
     * @param inputString Input {@code String} this a task to be calculated
     * @return A {@code String} reverse Polish notation
     */
    public String getNotation(String inputString) {
        Stack<String> stack = new Stack<String>();
        StringTokenizer stringTokenizer = new StringTokenizer(inputString,
                OPERATORS + " ()", true);
        String lastElement;
        StringBuilder notation = new StringBuilder("");

        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            if (isOperator(token)) {
                while (!stack.empty()) {
                    if (isOperator(stack.lastElement()) && (priorityOfOperation(token) <= priorityOfOperation(stack.lastElement()))) {
                        notation.append(stack.pop()).append(" ");
                    } else {
                        break;
                    }
                }
                stack.push(token);
            } else if ("(".equals(token)) {
                stack.push(token);
            } else if (")".equals(token)) {
                lastElement = stack.lastElement();
                while (!"(".equals(lastElement)) {
                    notation.append(stack.pop()).append(" ");
                    lastElement = stack.lastElement();
                }
                stack.pop();
            } else {
                notation.append(token).append(" ");
            }
        }
        while (!stack.empty()) {
            notation.append(stack.pop()).append(" ");
        }

        return notation.toString();
    }

    /**
     * Method checked {@code currentSymbol} is a number or not.
     *
     * @param currentSymbol Input string that we check
     * @return True if {@code currentSymbol} is number,
     * false otherwise
     */
    private boolean isNumber(String currentSymbol) {
        try {
            Double.parseDouble(currentSymbol);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method checked {@code operation} is a operation or not.
     * Return true if {@code operation} is operation ,
     * false otherwise
     *
     * @param operation Input string that we check
     * @return True if {@code operation} is operation,
     * false otherwise
     */
    private boolean isOperator(String operation) {
        return "+".equals(operation) || "*".equals(operation) || "/".equals(operation) || "-".equals(operation);
    }

    /**
     * Method checked priority input a operation.
     * Priority 1 : operation {@code +-}
     * Priority 2 : operation {@code /*}
     *
     * @param operation String operation for checked priority
     * @return Priority operation {@code int}
     */
    private int priorityOfOperation(String operation) {
        switch (operation) {
            case "/":
            case "*":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return 0;
        }
    }

    /**
     * Calculate reverse Polish {@code notation}
     *
     * @param notation reverse Polish notation
     * @return double result calculate notation
     */
    public double calculateResult(String notation) {
        Stack<String> stack = new Stack<String>();

        for (String currentSymbol : notation.split(" ")) {
            if (isNumber(currentSymbol)) {
                stack.push(currentSymbol);

            }

            if (isOperator(currentSymbol)) {
                double result = 0;
                double first = Double.parseDouble(String.valueOf(stack.pop()));
                double second = Double.parseDouble(String.valueOf(stack.pop()));

                switch (currentSymbol) {
                    case "/":
                        result = second / first;
                        break;
                    case "*":
                        result = second * first;
                        break;
                    case "+":
                        result = second + first;
                        break;
                    case "-":
                        result = second - first;
                        break;
                }
                stack.push(String.valueOf(result));
            }
        }
        return Double.parseDouble(stack.pop());
    }
}
