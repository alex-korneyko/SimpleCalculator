package ua.in.dris4ecoder.SimpleCalculator;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Alex Korneyko on 04.07.2016 16:05.
 */
class OneOrTwoOperandsNormalNotationParser implements Parser {

    private List<ValueParser> valueParsers = new ArrayList<>();
    private String parsedExpression;
    private List<Double> operands;
    private char operator;


    @Override
    public void addNewValueParser(ValueParser valueParser) {
        valueParsers.add(valueParser);
    }

    @Override
    public boolean parse(String expression) throws NumberFormatException {

        parsedExpression = expression;
        boolean isParsed = false;
        operator = 0;
        operands = new ArrayList<>();
        String[] splitExpression = expression.split(" ");

        for (String element : splitExpression) {
            if (operands.size() == 2) {
                break;
            }

            char firstChar = element.toCharArray()[0];

            if ((firstChar >= '0' && firstChar <= '9') || firstChar == '#' || (firstChar == '-' && element.length() > 1)) {
                double operand = 0;

                if (firstChar == '#') {
                    ValueParser valueParser = null;

                    for (ValueParser parser : valueParsers) {
                        if (parser.dataTypeIdentitySymbol() == element.charAt(1)) {
                            valueParser = parser;
                        }
                    }

                    if (valueParser == null) {
                        throw new NumberFormatException("Data type not found: " + element.charAt(1));
                    }

                    try {
                        operand = valueParser.parse(element.substring(2));
                        isParsed = true;
                    } catch (NumberFormatException ignored) {
                    }

                } else {
                    for (ValueParser valueParser : valueParsers) {
                        try {
                            operand = valueParser.parse(element);
                            isParsed = true;
                            break;
                        } catch (NumberFormatException ignored) {
                        }
                    }
                }

                if (isParsed) {
                    operands.add(operand);
                } else {
                    throw new NumberFormatException("Wrong value: " + element);
                }

            } else if (element.length() == 1) {
                operator = element.charAt(0);
            } else {
                throw new NumberFormatException("Wrong value: " + element);
            }
        }

        return true;
    }

    @Override
    public String getParsedExpression() {
        return parsedExpression;
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
