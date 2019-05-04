package com.company.Model;
import java.util.ArrayList;

public class IntegerList {

    private ArrayList <Integer> list = new ArrayList<>();

    public IntegerList(){
        for (int i = 0; i < 15; i++){
            Integer elem = (int)(Math.random()*50);
            list.add(elem);
        }

    }

    public IntegerList(int length) {
        for (int i = 0; i < length; i++) {
            Integer elem = (int) (Math.random() * 50);
            list.add(elem);
        }
    }

    public IntegerList(ArrayList <Integer> lst){
            list.addAll(lst);
        }

    public void bublesort (){

            for(int i = list.size()-1 ; i > 0 ; i--){
                for(int j = 0 ; j < i ; j++){

                    if( list.get(j) > list.get(j+1) ){
                        Integer tmp = list.get(j);
                        list.set(j,list.get(j+1));
                        list.set(j+1,tmp);
                    }
                }
            }

    }

    public ArrayList <Integer> getList(){
        return list;
    }

}
