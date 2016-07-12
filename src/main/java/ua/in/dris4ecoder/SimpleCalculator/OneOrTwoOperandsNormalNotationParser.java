package ua.in.dris4ecoder.SimpleCalculator;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Alex Korneyko on 04.07.2016 16:05.
 */
class OneOrTwoOperandsNormalNotationParser implements Parser {

    List<ValueParser> valueParsers = new ArrayList<>();
    private List<Double> operands;
    private char operator;


    @Override
    public void addNewValueParser(ValueParser valueParser) {
        valueParsers.add(valueParser);
    }

    @Override
    public void parse(String expression) throws NumberFormatException {

        boolean isParsed = false;
        operands = new ArrayList<>();
        String[] splitExpression = expression.split(" ");

        for (String element : splitExpression) {
            if (operands.size() == 2) {
                break;
            }

            char firstChar = element.toCharArray()[0];

            if (firstChar >= '0' && firstChar <= '9') {
                double operand = 0;

                for (ValueParser valueParser : valueParsers) {
                    try {
                        operand = valueParser.parse(element);
                        isParsed = true;
                        break;
                    } catch (NumberFormatException ignored) {}
                }

                if (isParsed) {
                    operands.add(operand);
                } else {
                    throw new NullPointerException("Wrong value: " + element);
                }

//                operands.add(Double.parseDouble(element));
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
