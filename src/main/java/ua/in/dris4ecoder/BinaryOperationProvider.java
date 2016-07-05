package ua.in.dris4ecoder;

import java.util.List;

/**
 * Created by Alex Korneyko on 05.07.2016 16:19.
 */
public interface BinaryOperationProvider {

    List<BinaryOperation> getBinaryOperations();

    void init();
}
