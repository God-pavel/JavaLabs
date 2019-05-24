package com.company.Exceptions;

import com.company.View.View;

public class OutOfLengthException extends Exception {

    public OutOfLengthException(String msg) {
        View.printMessage(msg);
    }
}
