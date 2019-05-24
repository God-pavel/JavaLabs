package com.company;

import com.company.View.Viewer;
import java.util.Scanner;

public class ConsoleReader {

    public static Integer insertInt(){
        Integer num = 0;
        boolean check = true;

        while (check) {
            try {
                Scanner in = new Scanner(System.in);
                num = in.nextInt();
                check = false;
            } catch (Exception e) {
                Viewer.printMessage("Введіть число.");
            }
        }
        return num;
    }

    public static String insertStr(){
        Scanner in = new Scanner(System.in);
        String  str = in.nextLine();
        return str;
    }
}
