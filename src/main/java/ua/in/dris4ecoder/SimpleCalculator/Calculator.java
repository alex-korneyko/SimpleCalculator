package ua.in.dris4ecoder.SimpleCalculator;

import java.util.IllegalFormatException;
import java.util.List;

/**
 * Created by Alex Korneyko on 04.07.2016 19:03.
 */
public class Calculator {

    private Parser parser;
    private List<BinaryOperation> binaryOperationsSet;
    private List<UnaryOperation> unaryOperationsSet;

    void setUnaryOperationsSet(List<UnaryOperation> unaryOperationsSet) {
        this.unaryOperationsSet = unaryOperationsSet;
    }

    void setBinaryOperationsSet(List<BinaryOperation> binaryOperationsSet) {
        this.binaryOperationsSet = binaryOperationsSet;
    }

    void setParser(Parser parser) {
        this.parser = parser;
    }

    public double compute(String expression) throws IllegalArgumentException {

        boolean operatorFound = false;
        double result = 0;
        parser.parse(expression);

        for (BinaryOperation binaryOperation : binaryOperationsSet) {
            if (binaryOperation.getOperator() != parser.getOperator()) {
                continue;
            }
            operatorFound = true;
            result = binaryOperation.calculate(parser.getOperands().get(0), parser.getOperands().get(1));
        }

        for(UnaryOperation unaryOperation: unaryOperationsSet){
            if(unaryOperation.getOperator() != parser.getOperator()){
                continue;
            }
            operatorFound = true;
            result = unaryOperation.calculate(parser.getOperands().get(0));
        }

        if (!operatorFound) {
            throw new IllegalArgumentException("Operator not found: '" + parser.getOperator() + "'");
        }

        return result;
    }

    public void addNewBinaryOperation(BinaryOperation binaryOperation) {

        binaryOperationsSet.add(binaryOperation);
    }

    public void addNewUnaryOperation(UnaryOperation unaryOperation) {

        unaryOperationsSet.add(unaryOperation);
    }

    public void addNewValueParser(ValueParser valueParser) {

        parser.addNewValueParser(valueParser);
    }

}
