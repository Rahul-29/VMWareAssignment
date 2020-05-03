package com.vmware.assignment.service;

import org.springframework.stereotype.Component;

@Component(value = "subtraction")
public class Subtraction implements Operation {
    @Override
    public int operation(int x, int y) {
        return x - y;
    }
}
