package com.company;

import java.util.Scanner;

public class ConsoleReader {
    public static Integer insertInt(){
        Scanner in = new Scanner(System.in);
        Integer  num = in.nextInt();
        return num;
    }
    public static String insertStr(){
        Scanner in = new Scanner(System.in);
        String  str = in.nextLine();
        return str;
    }
}
