package ua.in.dris4ecoder.SimpleCalculator;

import java.util.List;

/**
 * Created by Alex Korneyko on 04.07.2016 15:53.
 */
public interface Parser {

    void addNewValueParser(ValueParser valueParser);

    void parse(String expression);

    List<Double> getOperands();

    char getOperator();
}
