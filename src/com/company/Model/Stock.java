package com.company.Model;
import java.lang.String;

public class Stock {

    private String product;
    private String model;
    private String company;
    private long registrNum;
    private long amount;
    private float price;
    private int [] manufactureDate;

    public Stock(String product, String model, String company, long registrNum, long amount, float price,
                 int day, int month, int year){
        this.product = product;
        this.model = model;
        this.company = company;
        this.registrNum = registrNum;
        this.amount = amount;
        this.price = price;

        manufactureDate  = new int [3];
        int date[] =  {day, month, year};
        this.manufactureDate = date;
    }

    public Stock(){
        String [] products = {"Pen","Pencil","Ruler"};
        String [] models = {"Simple","Premium","Lux"};
        String [] companies = {"Microsoft", "Roshen", "Pixar"};
        this.product = products[(int)(Math.random()*3)];
        this.model = models[(int)(Math.random()*3)];
        this.company = companies[(int)(Math.random()*3)];
        this.registrNum = (long)(Math.random()*10000);
        this.amount = (long)(Math.random()*1000);
        this.price = (float)(Math.random()*100);
        int day = (int)(Math.random()*31);
        int month = (int)(Math.random()*12);
        int year = (int)(Math.random()*19 + 2000);
        int [] date  = {day, month, year};
        this.manufactureDate = date;
    }

    public String getProduct() { return product; }
    public String getModel() { return model; }
    public String getCompany() { return company; }
    public long getRegistrNum(){ return registrNum; }
    public long getAmount() { return amount; }
    public int [] getManufactureDate() { return manufactureDate; }
    public float getPrice() { return price; }

    public void setProduct(String product){
            this.product = product;
        }
    public void setModel(String model){
        this.model = model;
    }
    public void setCompany(String company){
        this.company = company;
    }
    public void setRegistrNum(long registrNum){
            this.registrNum = registrNum;
        }
    public void setAmount(long amount){
            this.amount = amount;
        }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setMileage(int day, int month, int year) {
        int [] date  = {day, month, year};
        this.manufactureDate = date;
    }


    public String toString(){
        String str = "Назва товару: " + product + '\n' + "Модель: " + model + '\n' + "Фірма виробника: " + company +
                '\n' + "Реєстраційний номер: " + registrNum + '\n' + "Кількість: " + amount +
                '\n'+ "Ціна: " + price + '\n' + "Дата виготовлення: " + manufactureDate[0] + "." + manufactureDate[1] +
                "." + manufactureDate[2];
        return str;
    }

}
