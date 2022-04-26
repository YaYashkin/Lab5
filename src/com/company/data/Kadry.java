package com.company.data;

public abstract class Kadry {
    protected String name;
    protected int age;

    public Kadry(String name, int age){
        this.age = age;
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String str){
        this.name = str;
    }



    public abstract String Type();
}
