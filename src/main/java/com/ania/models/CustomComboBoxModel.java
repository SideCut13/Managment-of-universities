package com.ania.models;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class CustomComboBoxModel<T> extends AbstractListModel<T> implements ComboBoxModel<T>
{
    private List<T> items;
    private T selectedItem;

    public CustomComboBoxModel(List<T> items) {
        this.items = items;

        if(!items.isEmpty() && items != null)
        {
            selectedItem = items.get(0);
        }
    }

    public void update(List<T> items) {
        this.items = items;

        if(!items.isEmpty() && items != null)
        {
            selectedItem = items.get(0);
        }
    }

    @Override
    public T getElementAt(int index) {
        return items.get(index);
    }

    @Override
    public int getSize() {
        return items.size();
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (T)anItem;

    }


}
