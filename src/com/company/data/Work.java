package com.company.data;

public class Work extends Kadry {
    private int time;

    public Work(String name, int age, int time){
        super(name, age);
        this.time = time;
    }

    public int getTime(){
        return time;
    }

    public void setTime(int time){
        this.time = time;
    }

    @Override
    public String Type() {
        return "Рабочий";
    }
}
