package com.company;

import com.company.Exceptions.MenuException;
import com.company.Exceptions.OutOfLengthException;

public class Validator {
    public static void checkMenuNumber(String menuNumber) throws MenuException {
        if(!menuNumber.equals("1") && !menuNumber.equals("2") && !menuNumber.equals("3") && !menuNumber.equals("4")) {
            throw new MenuException("MenuException: Was written wrong number!");
        }
    }
    public static void checkString(String checkedString) throws OutOfLengthException {
        if(checkedString.length() > 100 || checkedString.length() < 1) {
            throw new OutOfLengthException("OutOfLengthException: ");
        }
    }
}
