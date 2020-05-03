package com.vmware.assignment.service;

import org.springframework.stereotype.Component;

@Component(value = "addition")
public class Addition implements Operation {
    @Override
    public int operation(int x, int y) {
        return x + y;
    }
}
