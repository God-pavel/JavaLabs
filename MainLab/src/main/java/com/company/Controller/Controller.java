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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Controller {


    public static void startMenu(){

        Logger logger = LogManager.getLogger(Controller.class);
        Logger errorLoger = LogManager.getRootLogger();

        logger.info("Program was started");

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
                    Stock[] stocks = {};

                    while(onFile){
                        View.printMessage("Введіть ім'я файла");
                        String filepath = "/home/pavel/IdeaProjects/JavaLabs/MainLab/src/main/java/files/" + ConsoleImport.insert();
                        View.printMessage(""+filepath.charAt(filepath.length()-1));
                        switch (filepath.charAt(filepath.length()-1)) {
                            case 'n':
                                try {
                                    stocks = FileReader.readerJSON(filepath);
                                } catch (Exception e) {
                                    View.printMessage("Exception has occurred while reading file!");
                                    errorLoger.error("Program was interupted because the name of file was wrong");
                                    System.exit(0);
                                }
                                onFile = false;
                                break;
                            case 't':
                                try {
                                    stocks = FileReader.readerTXT(filepath);
                                } catch (Exception e) {
                                    View.printMessage("Exception has occurred while reading file!");
                                    errorLoger.error("Program was interupted because the name of file was wrong");
                                    System.exit(0);
                                }
                                onFile = false;
                                break;
                            default:
                                View.printMessage("Некоректне ім'я файла");
                                logger.warn("Was entered wrong name of file");
                                break;
                        }
                    }
                    sel1 = new Selection(stocks);
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
                    logger.warn("Was entered wrong number");
                    break;
            }
        }

        FileWritter.outputCleaner("/home/pavel/IdeaProjects/JavaLabs/MainLab/src/main/java/files/output.txt");

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
                logger.warn("Was entered wrong number");
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
                        logger.warn("Was entered wrong number of symbols");
                        continue;
                    }
                    sel1.showProductsByCompany(company);
                    sel1.writeProductsByCompany(company,"/home/pavel/IdeaProjects/JavaLabs/MainLab/src/main/java/files/output.txt", onMenu);
                    break;
                case "2":
                    View.printMessage("Введіть назву товару");
                    String product;
                    try {
                        product = ConsoleImport.insert();
                        Validator.checkString(product);
                    } catch (OutOfLengthException e) {
                        View.printMessage("Please write more then 1 and less then 100 symbols");
                        logger.warn("Was entered wrong number of symbols");
                        continue;
                    }
                    sel1.showCompaniesByProduct(product);
                    sel1.writeCompaniesByProduct(product,"/home/pavel/IdeaProjects/JavaLabs/MainLab/src/main/java/files/output.txt", onMenu);
                    break;
                case "3":
                    View.printSelection(sel1);
                    break;
                case "4":
                    View.printMessage("Ви вийшли з програми.");
                    logger.info("Program was closed");
                    onMenu = false;
                    break;

            }
        }

    }
}
