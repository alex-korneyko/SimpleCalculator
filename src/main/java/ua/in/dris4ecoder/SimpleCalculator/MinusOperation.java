package ua.in.dris4ecoder.SimpleCalculator;

/**
 * Created by Alex Korneyko on 04.07.2016 19:01.
 */
class MinusOperation implements BinaryOperation {

    @Override
    public double calculate(double operand1, double operand2) {
        return operand1 - operand2;
    }

    @Override
    public char getOperator() {
        return '-';
    }
}
