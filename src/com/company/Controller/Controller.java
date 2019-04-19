package com.company.Controller;

import com.company.*;
import com.company.Exceptions.MenuException;
import com.company.Exceptions.OutOfLengthException;
import com.company.FileController.FileReader;
import com.company.FileController.FileWritter;
import com.company.Model.Stock;
import com.company.Validator;
import com.company.Model.Selection;
import com.company.View.View;



public class Controller {
    public static void startMenu(){

        try {
        boolean firstON = true;
        Selection sel1 = new Selection(0);
        while (firstON) {

            View.printMessage("Натисніть 1, щоб зчитати данні з файла." + '\n' +
                    "Натисніть 2, для автоматичної генерації");

            String firstChoice;
            firstChoice = ConsoleImport.insert();

            switch (firstChoice) {
                case "1":
                    boolean onFile = true;
                    while(onFile){
                        View.printMessage("Введіть ім'я файла");
                        String filepath;
                        filepath = ConsoleImport.insert();
                        Stock[] stocks;
                        switch (filepath.charAt(filepath.length()-1)) {
                            case 'n':
                                stocks = FileReader.JSONReader(filepath);
                                sel1 = new Selection(stocks);
                                onFile = false;
                                break;
                            case 't':
                                stocks = FileReader.TXTReader(filepath);
                                sel1 = new Selection(stocks);
                                onFile = false;
                                break;
                            default:
                                View.printMessage("Некоректне ім'я файла");
                        }
                    }
                    View.printSelection(sel1);
                    firstON = false;
                    break;
                case "2":
                    sel1 = new Selection(10);
                    View.printSelection(sel1);
                    firstON = false;
                    break;
                default:
                    View.printMessage("Натисніть 1 або 2");
                    break;
            }
        }

        FileWritter.outputCleaner("output.txt");

        boolean onMenu = true;
        while (onMenu) {
            View.printMessage("Натисніть 1, щоб отримати список товарів заданої фірми виробника." + '\n' +
                    "Натисніть 2, щоб oтримати список фірм виробників для заданого товару." + '\n' +
                    "Натисніть 3, щоб вивести таблицю." + '\n' +
                    "Натисніть 4, щоб вийти з програми.");

            String choice;

            try {
                choice = ConsoleImport.insert();
                Validator.checkMenuNumber(choice);
            } catch (MenuException e) {
                View.printMessage("Please write number 1-4");
                continue;
            }


            switch (choice) {
                case "1":
                    View.printMessage("Введіть фірму виробник");
                    String company;
                    try {
                        company = ConsoleImport.insert();
                        Validator.checkString(company);
                    } catch (OutOfLengthException e) {
                        View.printMessage("Please write more then 1 and less then 100 symbols");
                        continue;
                    }
                    sel1.showProductsByCompany(company);
                    sel1.writeProductsByCompany(company,"output.txt", onMenu);
                    break;
                case "2":
                    View.printMessage("Введіть назву товару");
                    String product;
                    try {
                        product = ConsoleImport.insert();
                        Validator.checkString(product);
                    } catch (OutOfLengthException e) {
                        View.printMessage("Please write less then 100 symbols");
                        continue;
                    }
                    sel1.showCompaniesByProduct(product);
                    sel1.writeCompaniesByProduct(product,"output.txt", onMenu);
                    break;
                case "3":
                    View.printSelection(sel1);
                    break;
                case "4":
                    View.printMessage("Ви вийшли з програми.");
                    onMenu = false;
                    break;

            }
        }
        } catch (Exception e) {
        View.printMessage("Exception has occurred while reading file!");
    }
    }
}
