package com.company.FileController;
import com.company.Model.Stock;
import com.company.View.View;
import com.google.gson.*;

import java.io.*;

public class FileReader {

    public static Stock [] readerJSON(String filepath) throws IOException{

        String str = fileToString(filepath);
        String [] arr = str.split(",\n");
        Stock [] stocks = new Stock[arr.length];
        for (int i =0; i < arr.length; i++){
            stocks[i] = stringToObjJSON(arr[i]);
        }
        return stocks;
    }

    public static Stock [] readerTXT(String filepath) throws IOException{

        String str = fileToString(filepath);
        String [] arr = str.split(";\n");
        View.printList(arr);
        Stock [] stocks = new Stock[arr.length];
        for (int i =0; i < arr.length; i++){
            stocks[i] = stringToObj(arr[i]);
        }
        return stocks;
    }

    private static Stock stringToObjJSON(String str){
        Gson gson = new Gson();
        Stock stock = gson.fromJson(str, Stock.class);
        return stock;
    }

    private static Stock stringToObj(String str){
        String [] arr = str.split(",");
        Stock cur = new Stock(arr[0], arr[1], arr[2], Long.parseLong(arr[3]), Long.parseLong(arr[4]), Float.parseFloat(arr[5]),
                Integer.parseInt(arr[6]), Integer.parseInt(arr[7]), Integer.parseInt(arr[8]));
        return cur;
    }


    public static String fileToString(String filePath) throws IOException {
        FileInputStream fr = new FileInputStream(filePath);
        String string;
        byte[] byteArr = new byte[fr.available()];
        fr.read(byteArr);
        string = new String(byteArr);
        fr.close();
        return string;
    }
}



