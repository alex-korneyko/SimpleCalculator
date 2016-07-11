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
    public void parse(String expression) throws NumberFormatException {

        operands = new ArrayList<>();
        String[] splitExpression = expression.split(" ");

        for (String element : splitExpression) {
            if(operands.size() == 2){
                break;
            }

            char firstChar = element.toCharArray()[0];

            if (firstChar >= '0' && firstChar <= '9') {
                operands.add(Double.parseDouble(element));
            } else if (element.length() == 1) {
                operator = element.charAt(0);
            }
        }
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
