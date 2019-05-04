package com.company.View;

import com.company.Model.IntegerList;


public class Viewer {
    public static void printList(IntegerList list) {
        for (int i = 0; i < list.getList().size()-1; i ++) {
            System.out.print(list.getList().get(i) +", ");
        }

        System.out.println(list.getList().get(list.getList().size()-1));
    }

    public static void printMessage(String mes) {
        System.out.println(mes);
    }
}
