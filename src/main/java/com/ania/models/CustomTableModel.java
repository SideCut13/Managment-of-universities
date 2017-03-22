package com.ania.models;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.ania.domain.StudentUniversity;

public class CustomTableModel extends AbstractTableModel{

    private List<StudentUniversity> rows;
    private List<String> columns;


    public CustomTableModel(List<StudentUniversity> rows, List<String> columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public void update(List<StudentUniversity> rows) {
        this.rows = rows;
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        StudentUniversity su = rows.get(row); //pobieram wiersz

        if (col == 0)
        {
            return su.getId();
        }
        else if (col == 1)
        {
            return su.getStudentName();
        }
        else if (col == 2)
        {
            return su.getSurname();
        }
        else if (col == 3)
        {
            return su.getAge();
        }
        else if (col == 4)
        {
            return su.getStudentAddress();
        }
        else if (col == 5)
        {
            return su.getStudentEmail();
        }
        else if (col == 6)
        {
            return su.getUniversityName();
        }
        else if (col == 7)
        {
            return su.getCity();
        }
        else if (col == 8)
        {
            return su.getUniversityAddress();
        }
        else if (col == 9)
        {
            return su.getUniversityEmail();
        }
        else if (col == 10)
        {
            return su.getTelephoneNumber();
        }
        else if (col == 11)
        {
            return su.getYear();
        }
        else if (col == 12)
        {
            return su.getStudentFee();
        }
        else
        {
            return su.getStudentYear();
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns.get(column);
    }

}
