package com.company;

import com.company.data.*;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
    private All data;
    public MyTableModel(All all){
        this.data = all;
    }

    @Override
    public int getRowCount() {
        return data.getCount();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 1:
            case 4:
                return String.class;
            case 2:
            case 3:
            case 5:
                return Integer.class;
        }
        return String.class;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 1: data.getKadry(rowIndex).setName((String) aValue); break;
            case 2: data.getKadry(rowIndex).setAge((Integer) aValue); break;
            case 3: data.getWork(rowIndex).setTime((Integer) aValue); break;
            case 4: data.getEngener(rowIndex).setPosition((String) aValue); break;
            case 5: data.getAdmin(rowIndex).setPeople((Integer) aValue); break;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 1: return true;
            case 2: return true;
            case 3: {
                Kadry k = data.getKadry(rowIndex);
                if(k instanceof Work){
                    return true;
                }else return false;
            }
            case 4: {
                Kadry k = data.getKadry(rowIndex);
                if(k instanceof Engener){
                    return true;
                }else return false;
            }
            case 5: {
                Kadry k = data.getKadry(rowIndex);
                if(k instanceof Admin){
                    return true;
                }else return false;
            }
        }
        return false;
    }

    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "Кадр";
            case 1: return "Имя";
            case 2: return "Возраст";
            case 3: return "Кол-во часов";
            case 4: return "Должность: Инженер-";
            case 5: return "Кол-во подчинённых";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return data.getKadry(rowIndex).Type();
            case 1: return data.getKadry(rowIndex).getName();
            case 2: return data.getKadry(rowIndex).getAge();
            case 3:{
                Kadry k = data.getKadry(rowIndex);
                if(k instanceof Work){
                    return ((Work) k).getTime();
                }else if(k instanceof Engener){
                    return "";
                }else{
                    return "";
                }
            }
            case 4:{
                Kadry k = data.getKadry(rowIndex);
                if(k instanceof Work){
                    return "";
                }else if(k instanceof Engener){
                    return ((Engener) k).getPosition();
                }else{
                    return "";
                }
            }
            case 5:{
                Kadry k = data.getKadry(rowIndex);
                if(k instanceof Work){
                    return "";
                }else if(k instanceof Engener){
                    return "";
                }else{
                    return ((Admin) k).getPeople();
                }
            }
        }
        return "default";
    }

    public void delete(int ind){
        this.data.remove(ind);
        fireTableDataChanged();
    }

    public void AddKadrInt(int type, String name, int age, int count){
        switch (type){
            case 0: data.AddKadr(new Work(name, age, count)); break;
            case 2: data.AddKadr(new Admin(name, age, count)); break;
        }
        fireTableDataChanged();
    }

    public void AddKadrString(int type, String name, int age, String str){
        switch (type){
            case 1: data.AddKadr(new Engener(name, age, str)); break;
        }
        fireTableDataChanged();
    }
}
