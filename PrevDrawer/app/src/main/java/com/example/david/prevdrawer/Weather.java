package com.example.david.prevdrawer;

/**
 * Created by david on 13/06/2018.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Created by david on 14/03/2018.
 */

public class Weather  {

    private int id;
    private String name;
    private String state;
    private String country;
    private Data dados;



    public Weather(int id, String name, String state, String country ){
        this.id = id;
        this.name = name;
        this.state = state;
        this.country = country;

    }

    public Weather(){

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public Data getData(){
        return dados;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setState(String state){
        this.state = state;
    }
    public void setCountry(String country){
        this.country = country;
    }

    public void setDados(Data dados){
        this.dados = dados;
    };


}
