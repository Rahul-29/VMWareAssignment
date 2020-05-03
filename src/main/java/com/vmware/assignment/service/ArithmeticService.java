package com.vmware.assignment.service;

import com.vmware.assignment.model.Output;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class ArithmeticService {

    @Autowired
    @Qualifier("addition")
    private Operation arithmeticOperation;

    @Autowired
    @Qualifier("subtraction")
    private Operation subtractionOperation;

    public Output performAddition(int x, int y){
        Output output = new Output();
        int result = arithmeticOperation.operation(x, y);
        output.setResult(String.valueOf(result));
        return output;
    }

    public Output performSubtraction(int x, int y){
        Output output = new Output();
        int result = subtractionOperation.operation(x, y);
        output.setResult(String.valueOf(result));
        return output;
    }
}
