package com.company.data;

public class Engener extends Kadry {
    private String position;

    public Engener(String name, int age, String position){
        super(name, age);
        this.position = position;
    }

    public String getPosition(){
        return position;
    }

    public void setPosition(String position){
        this.position = position;
    }

    @Override
    public String Type() {
        return "Инженер";
    }
}
