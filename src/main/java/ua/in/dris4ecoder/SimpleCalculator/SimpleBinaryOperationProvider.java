package ua.in.dris4ecoder.SimpleCalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Korneyko on 05.07.2016 16:22.
 */
class SimpleBinaryOperationProvider implements BinaryOperationProvider {

    private List<BinaryOperation> binaryOperations = new ArrayList<>();

    @Override
    public List<BinaryOperation> getBinaryOperations() {

        return binaryOperations;
    }

    @Override
    public void addOperation(BinaryOperation binaryOperation) {

        binaryOperations.add(binaryOperation);
    }

    @Override
    public void init() {

        addOperation(new PlusOperation());
        addOperation(new MinusOperation());

    }
}
