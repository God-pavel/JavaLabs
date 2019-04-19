package com.company.Model;

import com.company.FileController.FileWritter;
import com.company.View.View;

import java.io.IOException;

public class Selection {

    private  Stock[] selection;
    private int len = 0;

    private void add(Stock element){
        selection[len] = element;
        len++;
    }

    public int getLen(){
        return len;
    }

    public Stock [] getSelection(){
        return selection;
    }

    public Selection(int length) {
        selection = new Stock[length];
        for (int i = 0; i <selection.length; i++ ){
            Stock cur = new Stock();
            this.add(cur);
        }
    }

    public Selection(Stock [] stocks){
        selection = new Stock[stocks.length];
        for (int i = 0; i <selection.length; i++ ){
            Stock cur = stocks[i];
            this.add(cur);
        }
    }

    private String [] getProductsByCompany(String company){
        int curlen = 0;
        for (int i = 0; i < this.len; i++){
            if (selection[i].getCompany().toLowerCase().equals(company.toLowerCase())){
                curlen++;
            }
        }
        String [] products = new String [curlen];
        int counter = 0;
        for (int i = 0; i < this.len; i++){
            if (selection[i].getCompany().toLowerCase().equals(company.toLowerCase())){
                products[counter] = selection[i].getRegistrNum() + "";
                counter++;
            }
        }
        return products;
    }

    public void writeProductsByCompany(String company,String filepath, boolean flag){
        String [] products = this.getProductsByCompany(company);
        try {
            FileWritter.ArrayWritter(products,filepath, flag);
        } catch (IOException e)
        {
            View.printMessage("Exception has occurred while writing to file!");
        }
    }

    public void showProductsByCompany(String company){
        String [] products = this.getProductsByCompany(company);
        View.printList(products);
    }

    private String [] getCompaniesByProduct(String product) {
        String[] companies = new String[this.len];
        int counter = 0;
        for (int i = 0; i < this.len; i++) {
            if (selection[i].getProduct().toLowerCase().equals(product.toLowerCase())) {
                boolean flag = true;
                for (int g = 0; g < counter; g++) {
                    if (companies[g].equals(selection[i].getCompany())) {
                        flag = false;
                    }
                }
                if (flag) {
                    companies[counter] = selection[i].getCompany();
                    counter++;
                }
            }
        }

        int nuls = 0;
        for (int i = 0; i < companies.length; i++){
            if (companies[i] == null){nuls++;}
        }

        String[] comp = new String[companies.length-nuls];
        int count = 0;
        for (int i = 0; i < companies.length; i++){
            if (companies[i] != null){
                comp[count] = companies[i];
                count++;
            }
        }

    return  comp;
    }

    public void showCompaniesByProduct(String product){
        String [] companies = this.getCompaniesByProduct(product);
        View.printList(companies);
    }

    public void writeCompaniesByProduct(String company,String filepath, boolean flag){
        String [] companies = this.getCompaniesByProduct(company);
        try {
            FileWritter.ArrayWritter(companies, filepath, flag);
        } catch (IOException e)
        {
            View.printMessage("Exception has occurred while writing to file!");
        }
    }
}

