package ua.in.dris4ecoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Korneyko on 05.07.2016 16:22.
 */
class SimpleBinaryOperationProvider implements BinaryOperationProvider {

    private List<BinaryOperation> binaryOperations;

    @Override
    public List<BinaryOperation> getBinaryOperations() {

        return binaryOperations;
    }

    @Override
    public void init() {
        binaryOperations = new ArrayList<>();

        binaryOperations.add(new PlusOperation());
        binaryOperations.add(new MinusOperation());

    }
}
