package ua.in.dris4ecoder.SimpleCalculator;

import java.util.List;

/**
 * Created by Alex Korneyko on 05.07.2016 16:19.
 */
interface BinaryOperationProvider {

    List<BinaryOperation> getBinaryOperations();

    void init();
}
