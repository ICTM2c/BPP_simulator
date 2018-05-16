package com.company;

public class Doos {
    private int doosCapacity;



    public Doos(int doosId) {
    this.doosCapacity = 50;
    }


    public int getDoosCapacity() {

        return doosCapacity;
    }


    public void setDoosCapacity(int doosCapacity) {
        this.doosCapacity = doosCapacity;
    }




    public String toString(){
        return "Doos 1 heeft een grootte van " + getDoosCapacity();

}

}

