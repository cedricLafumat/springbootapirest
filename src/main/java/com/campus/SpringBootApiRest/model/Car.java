package com.campus.SpringBootApiRest.model;

public class Car {

    private int id;
    private String model;
    private String marque;
    private String color;

    public Car(){

    }

    public Car(int id, String model, String marque, String color){
        this.id = id;
        this.model = model;
        this.marque = marque;
        this.color = color;
    }


    /* Getter */

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getMarque() {
        return marque;
    }

    public String getColor() {
        return color;
    }

    /* Setter */

    public void setId(int id){
        this.id = id;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setMarque(String marque){
        this.marque = marque;
    }

    public void seColor(String color){
        this.color = color;
    }
}
