package ua.in.dris4ecoder.SimpleCalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Korneyko on 04.07.2016 16:05.
 */
class OneOrTwoOperandsNormalNotationParser implements Parser {

    private List<Double> operands;
    private char operator;

    @Override
    public void parse(String expression) {

        operands = new ArrayList<>();
        String number = "";

        for (char exprElement : expression.toCharArray()) {
            if (exprElement == ' ') continue;

            if ((exprElement >= '0' && exprElement <= '9') || exprElement == '.') {
                number += exprElement;
            } else {
                operator = exprElement;
                if (!number.equals("")) {
                    try {
                        operands.add(Double.parseDouble(number));
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong notation");
                    }
                }
                number = "";
            }
        }

        operands.add(Double.parseDouble(number));
    }

    @Override
    public List<Double> getOperands() {
        return operands;
    }

    @Override
    public char getOperator() {
        return operator;
    }
}
