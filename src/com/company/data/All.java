package com.company.data;

import java.io.*;
import java.util.ArrayList;

public class All implements Serializable{
    private ArrayList<Kadry> kadrys = new ArrayList<Kadry>();
    public All(){
        kadrys.add(new Admin("Пётр", 35, 12));
        kadrys.add(new Admin("Александр", 37, 22));
        kadrys.add(new Engener("Николай", 40, "конструктор"));
        kadrys.add(new Engener("Алексей", 55, "технолог"));
        kadrys.add(new Work("Виктор", 55, 600));
        kadrys.add(new Work("Евгений", 20, 300));
        kadrys.add(new Work("Владислав", 26, 400));
        kadrys.add(new Admin("Руслан", 20, 30));
        kadrys.add(new Work("Вова", 20, 250));
        kadrys.add(new Work("Костя", 26, 210));
        kadrys.add(new Engener("Стас", 37, "программист"));
        kadrys.add(new Work("Миша", 26, 360));
    }

    public int getCount() {
        return this.kadrys.size();
    }

    public Kadry getKadry(int index) {
        return kadrys.get(index);
    }

    public Work getWork(int index){
        return (Work) kadrys.get(index);
    }

    public Engener getEngener(int index){
        return (Engener) kadrys.get(index);
    }

    public Admin getAdmin(int index){
        return (Admin) kadrys.get(index);
    }

    public void AddKadr(Kadry kadry){
        kadrys.add(kadry);
    }

    public void remove(int ind) {
        this.kadrys.remove(ind);
    }
}
