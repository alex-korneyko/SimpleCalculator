package ua.in.dris4ecoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Korneyko on 05.07.2016 20:24.
 */
class SimpleUnaryOperationProvider implements UnaryOperationProvider {

    private List<UnaryOperation> unaryOperations;

    @Override
    public List<UnaryOperation> getUnaryOperations() {

        return unaryOperations;
    }

    @Override
    public void init() {
        unaryOperations = new ArrayList<>();
    }
}
