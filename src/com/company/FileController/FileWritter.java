package com.company.FileController;
import com.company.View.View;

import java.io.*;

public class FileWritter {

    public static void ArrayWritter(String [] arr, String filepath, boolean flag) throws IOException {

        FileWriter writer = new FileWriter(filepath, flag);
        String text = "";
        for (int i = 0; i < arr.length; i++){
            text = text.concat(arr[i]) + " ";
        }
        text = text + "\n";
        writer.write(text);
        writer.flush();
        writer.close();
        }

    public static void outputCleaner(String filepath){
        try {
            FileWriter writer = new FileWriter(filepath);
            writer.write("");
            writer.flush();
            writer.close();
        } catch (IOException e){
            View.printMessage("Exception has occurred while cleaning file!");
        }
    }
}
