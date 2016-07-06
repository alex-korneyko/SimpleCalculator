package ua.in.dris4ecoder.SimpleCalculator;

/**
 * Created by Alex Korneyko on 04.07.2016 15:59.
 */
public interface UnaryOperation {

    double calculate(double operand1);

    char getOperator();
}
