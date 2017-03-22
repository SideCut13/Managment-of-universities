package com.ania.models;

import java.util.List;

import javax.swing.AbstractListModel;

public class CustomJListModel<T> extends AbstractListModel<T>{

    private List<T> items;


    public CustomJListModel(List<T> items) {
        super();
        this.items = items;
    }

    public void update(List<T> items) {
        this.items = items;
    }

    @Override
    public T getElementAt(int idx) {
        return items.get(idx);
    }

    @Override
    public int getSize() {
        return items.size();
    }


}
