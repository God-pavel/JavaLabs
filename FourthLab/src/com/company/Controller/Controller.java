package com.company.Controller;

import com.company.ConsoleReader;
import com.company.Model.IntegerList;
import com.company.View.Viewer;
import java.util.ArrayList;


public class Controller {
    public static void startMenu() {

        boolean ONMenu = true;

        while (ONMenu) {

            Viewer.printMessage("Натисніть 1, щоб згенерувати список за 15-ти чисел." + '\n' +
                    "Натисніть 2, щоб згенерувати список заданої довжини." + '\n' +
                    "Натисніть 3, щоб самому задати список." + '\n' +
                    "Натисніть 4, для виходу з програми.");

            String firstChoice;
            firstChoice = ConsoleReader.insertStr();

            switch (firstChoice) {
                case "1":
                    IntegerList lst = new IntegerList();
                    Viewer.printList(lst);
                    Viewer.printMessage("Введіть число згідно якого треба переформувати список.");
                    int num = ConsoleReader.insertInt();
                    lst.bublesort();
                    Viewer.printList(lst);
                    break;
                case "2":
                    Integer len;
                    Viewer.printMessage("Введіть кількість елементів.");
                    len = ConsoleReader.insertInt();
                    lst = new IntegerList(len);
                    Viewer.printList(lst);
                    Viewer.printMessage("Введіть число згідно якого треба переформувати список.");
                    num = ConsoleReader.insertInt();
                    lst.bublesort();
                    Viewer.printList(lst);
                    break;
                case "3":
                    Viewer.printMessage("Введіть кількість елеметів.");
                    len = ConsoleReader.insertInt();
                    ArrayList<Integer> arr = new ArrayList<>();
                    for (int i = 0; i < len; i++) {
                        Viewer.printMessage("Введіть елемет.");
                        Integer tmp = ConsoleReader.insertInt();
                        arr.add(tmp);
                    }
                    lst = new IntegerList(arr);
                    Viewer.printList(lst);
                    Viewer.printMessage("Введіть число згідно якого треба переформувати список.");
                    num = ConsoleReader.insertInt();
                    lst.bublesort();
                    Viewer.printList(lst);
                    break;
                case "4":
                    Viewer.printMessage("Ви вийшли з програми.");
                    ONMenu = false;
                    break;
                default:
                    Viewer.printMessage("Натисніть 1, 2, 3 або 4.");
                    break;
            }
        }


    }
}
