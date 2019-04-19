package com.company.View;

import com.company.Model.Selection;

public class View {
    public static void printSelection(Selection sel){
        String [] [] table = new String[sel.getLen() + 1][8];
        table[0][0] = "                       ";
        for (int i = 1; i < sel.getLen() + 1; i++){
            table[i][0] = String.format("%-23s","Stock " + i);
        }
        table[0][1] = String.format("%-23s","Назва товару:");
        table[0][2] = String.format("%-23s","Модель:");
        table[0][3] = String.format("%-23s","Фірма виробника:");
        table[0][4] = String.format("%-23s","Реєстраційний номер:");
        table[0][5] = String.format("%-23s","Кількість:");
        table[0][6] = String.format("%-23s","Ціна:");
        table[0][7] = String.format("%-23s","Дата виготовлення:");

        for (int i = 1; i < sel.getLen() + 1; i++){
            table[i][1] = String.format("%-23s",sel.getSelection()[i-1].getProduct() + "");
        }
        for (int i = 1; i < sel.getLen() + 1; i++){
            table[i][2] = String.format("%-23s",sel.getSelection()[i-1].getModel() + "");
        }
        for (int i = 1; i < sel.getLen() + 1; i++){
            table[i][3] = String.format("%-23s",sel.getSelection()[i-1].getCompany() + "");
        }
        for (int i = 1; i < sel.getLen() + 1; i++){
            table[i][4] = String.format("%-23s",sel.getSelection()[i-1].getRegistrNum() + "");
        }
        for (int i = 1; i < sel.getLen() + 1; i++){
            table[i][5] = String.format("%-23s",sel.getSelection()[i-1].getAmount() + "");
        }
        for (int i = 1; i < sel.getLen() + 1; i++){
            table[i][6] = String.format("%-23s",sel.getSelection()[i-1].getPrice() + "");
        }
        for (int i = 1; i < sel.getLen() + 1; i++){
            table[i][7] = String.format("%-23s",sel.getSelection()[i-1].getManufactureDate()[0] + "." +
                    sel.getSelection()[i-1].getManufactureDate()[1] + "." + sel.getSelection()[i-1].getManufactureDate()[2]);
        }

        for(int i = 0 ; i < sel.getLen() + 1; i++){
            for(int g = 0; g < 8; g++){
                System.out.print(table[i][g]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printList(String [] list) {
        if (list.length > 0) {
            for (int i = 0; i < list.length; i++) {
                System.out.println(list[i]);
            }
        } else {
            System.out.println("Таких об'єктів не знайшлось");
        }
        System.out.println();
    }

    public static void printMessage(String mes) {
        System.out.println(mes);
    }
}
