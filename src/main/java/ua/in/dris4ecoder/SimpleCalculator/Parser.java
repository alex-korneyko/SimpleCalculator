package ua.in.dris4ecoder.SimpleCalculator;

import java.util.List;

/**
 * Created by Alex Korneyko on 04.07.2016 15:53.
 */
public interface Parser {

    void addNewValueParser(ValueParser valueParser);

    boolean parse(String expression);

    String getParsedExpression();

    List<Double> getOperands();

    char getOperator();
}
