package com.company.Exceptions;

import com.company.View.View;

public class MenuException extends Exception {

    public MenuException (String msg) {
        View.printMessage(msg);
    }
}