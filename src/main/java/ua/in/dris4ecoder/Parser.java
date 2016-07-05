package ua.in.dris4ecoder;

import java.util.List;

/**
 * Created by Alex Korneyko on 04.07.2016 15:53.
 */
public interface Parser {

    void parse(String expression);

    List<Double> getOperands();

    char getOperator();
}
