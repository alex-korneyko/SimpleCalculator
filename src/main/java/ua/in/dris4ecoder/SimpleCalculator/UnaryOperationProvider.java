package ua.in.dris4ecoder.SimpleCalculator;

import java.util.List;

/**
 * Created by Alex Korneyko on 05.07.2016 20:22.
 */
interface UnaryOperationProvider {

    List<UnaryOperation> getUnaryOperations();

    void addOperation(UnaryOperation unaryOperation);

    void init();
}
