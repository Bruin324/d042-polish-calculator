package com.company;

public class ReversePolishCalc {

    int topOfStack = 0;
    double number1;
    double number2;


    private String[] tokens;

    private String[] stack;

    public double calculate(String input) {

        tokens = input.split(",");

        stack = new String[tokens.length];

        for (String token : tokens) {
            switch (token) {
                case "+":
                    number2 = pop();
                    number1 = pop();
                    push(number1 + number2);
                    break;
                case "-":
                    number2 = pop();
                    number1 = pop();
                    push(number1 - number2);
                    break;
                case "*":
                    number2 = pop();
                    number1 = pop();
                    push(number1 * number2);
                    break;
                case "/":
                    number2 = pop();
                    number1 = pop();
                    push(number1 / number2);
                    break;
                default:
                    push(token);
                    break;

            }

        }

        return pop();
    }

    private void push(String number) {
        stack[topOfStack] = number;
        topOfStack++;

    }

    private void push(double d) {
        String number = Double.toString(d);
        stack[topOfStack] = number;
        topOfStack++;

    }

    private double pop() {
        topOfStack--;
        double number = Double.parseDouble(stack[topOfStack]);
        return number;
    }
}
