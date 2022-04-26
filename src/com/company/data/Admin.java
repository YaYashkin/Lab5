package com.company.data;

public class Admin extends Kadry {
    private int people;

    public Admin(String name, int age, int people){
        super(name, age);
        this.people = people;
    }

    public int getPeople(){
        return people;
    }

    public void setPeople(int people){
        this.people = people;
    }

    @Override
    public String Type() {
        return "Администратор";
    }
}
