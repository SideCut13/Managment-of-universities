package com.ania.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ania.database.Database;
import com.ania.domain.Student;

public class PanelStudent extends JPanel{

    private JButton btnLeft = new JButton("      ");
    private JButton btnRight = new JButton("      ");
    private JTextField tfId = new JTextField(12);

    private JLabel lName = new JLabel("NAME");
    private JLabel lSurname = new JLabel("SURNAME");
    private JLabel lAge = new JLabel("AGE");
    private JLabel lAddress = new JLabel("ADDRESS");
    private JLabel lEmail = new JLabel("EMAIL");

    private JTextField tfName = new JTextField(18);
    private JTextField tfSurname = new JTextField(18);
    private JTextField tfAge = new JTextField(18);
    private JTextField tfAddress = new JTextField(18);
    private JTextField tfEmail = new JTextField(18);

    private JButton btnInsert = new JButton("INSERT");
    private JButton btnDelete = new JButton("DELETE");
    private JButton btnUpdate = new JButton("UPDATE");

    private List<Student> students;
    private int idx = 0;

    private PanelRegistration panelRegistration;

    public PanelStudent(PanelRegistration panelRegistration) {
        super(new GridBagLayout());
        this.panelRegistration = panelRegistration;
        setBackground(new Color(254, 91, 172));

        JPanel panelDirections = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelDirections = new GridBagConstraints();
        panelDirections.setBackground(new Color(254, 91, 172));

        gbcPanelDirections.gridx = 0;
        gbcPanelDirections.gridy = 0;
        gbcPanelDirections.insets = new Insets(10, 15, 30, 15);
        btnLeft.setPreferredSize(new Dimension(90, 30));
        btnLeft.setBorder(BorderFactory.createRaisedBevelBorder());
        btnLeft.setBackground(new Color(254, 247, 34));
        btnLeft.addActionListener(e -> {
            --idx;
            if (idx < 0)
            {
                idx = students.size() - 1;
            }
            updateFields();
        });
        panelDirections.add(btnLeft, gbcPanelDirections);

        gbcPanelDirections.gridx = 1;
        gbcPanelDirections.gridy = 0;
        gbcPanelDirections.insets = new Insets(10, 15, 30, 15);
        tfId.setEditable(false);
        tfId.setBorder(BorderFactory.createLoweredBevelBorder());
        tfId.setBackground(new Color(255 , 255, 255));
        panelDirections.add(tfId, gbcPanelDirections);

        gbcPanelDirections.gridx = 2;
        gbcPanelDirections.gridy = 0;
        gbcPanelDirections.insets = new Insets(10, 15, 30, 15);
        btnRight.setPreferredSize(new Dimension(90, 30));
        btnRight.setBorder(BorderFactory.createRaisedBevelBorder());
        btnRight.setBackground(new Color(254, 247, 34));
        btnRight.addActionListener(e -> {
            ++idx;
            if(idx >= students.size()){
                idx = 0;
            }
            updateFields();
        });
        panelDirections.add(btnRight, gbcPanelDirections);

        //---------------------------------------------------------------------------
        JPanel panelFields = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelFields = new GridBagConstraints();
        panelFields.setBackground(new Color(254, 91, 172));


        //NAME TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 0;
        gbcPanelFields.insets = new Insets(30, 15, 10, 15);
        lName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        panelFields.add(lName, gbcPanelFields);
        //NAME FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 0;
        tfName.setEditable(false);
        tfName.setBorder(BorderFactory.createLoweredBevelBorder());
        tfName.setBackground(new Color(255, 255, 255));
        panelFields.add(tfName, gbcPanelFields);


        //SURNAME TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 1;
        gbcPanelFields.insets = new Insets(10, 15, 10, 15);
        lSurname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        panelFields.add(lSurname, gbcPanelFields);
        //SURNAME FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 1;
        tfSurname.setEditable(false);
        tfSurname.setBorder(BorderFactory.createLoweredBevelBorder());
        tfSurname.setBackground(new Color(255, 255, 255));
        panelFields.add(tfSurname, gbcPanelFields);


        //AGE TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 2;
        gbcPanelFields.insets = new Insets(10, 15, 10, 15);
        lAge.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        panelFields.add(lAge, gbcPanelFields);
        //AGE FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 2;
        tfAge.setEditable(false);
        tfAge.setBorder(BorderFactory.createLoweredBevelBorder());
        tfAge.setBackground(new Color(255, 255, 255));
        panelFields.add(tfAge, gbcPanelFields);


        //ADDRESS TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 3;
        gbcPanelFields.insets = new Insets(10, 15, 10, 15);
        lAddress.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        panelFields.add(lAddress, gbcPanelFields);
        //ADDRESS FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 3;
        tfAddress.setEditable(false);
        tfAddress.setBorder(BorderFactory.createLoweredBevelBorder());
        tfAddress.setBackground(new Color(255, 255, 255));
        panelFields.add(tfAddress, gbcPanelFields);


        //EMAIL TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 4;
        gbcPanelFields.insets = new Insets(10, 15, 25, 15);
        lEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        panelFields.add(lEmail, gbcPanelFields);
        //EMAIL FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 4;
        tfEmail.setEditable(false);
        tfEmail.setBorder(BorderFactory.createLoweredBevelBorder());
        tfEmail.setBackground(new Color(255, 255, 255));
        panelFields.add(tfEmail, gbcPanelFields);


        //---------------------------------------------------------------------------
        JPanel panelButtons = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelButtons = new GridBagConstraints();
        panelButtons.setBackground(new Color(254, 91, 172));



        //INSERT
        gbcPanelButtons.gridx = 0;
        gbcPanelButtons.gridy = 0;
        gbcPanelButtons.insets = new Insets(25, 15, 20, 15);
        btnInsert.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        btnInsert.setPreferredSize(new Dimension(100, 35));
        btnInsert.setBorder(BorderFactory.createRaisedBevelBorder());
        btnInsert.setBackground(new Color(254, 247, 34));
        btnInsert.addActionListener(e -> {
            openInsertWindow();
        });
        panelButtons.add(btnInsert, gbcPanelButtons);


        //DELETE
        gbcPanelButtons.gridx = 1;
        gbcPanelButtons.gridy = 0;
        gbcPanelButtons.insets = new Insets(25, 15, 20, 15);
        btnDelete.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        btnDelete.setPreferredSize(new Dimension(100, 35));
        btnDelete.setBorder(BorderFactory.createRaisedBevelBorder());
        btnDelete.setBackground(new Color(254, 247, 34));
        btnDelete.addActionListener(e -> {
            try {
                if (!tfId.getText().isEmpty())
                {
                    Database.deleteStudent(Integer.parseInt(tfId.getText()));
                    updateFieldsAfterDelete();
                }
                else{
                    JOptionPane.showMessageDialog(null,  "NO STUDENTS TO DELETE !!!");
                }
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
        panelButtons.add(btnDelete, gbcPanelButtons);


        //UPDATE
        gbcPanelButtons.gridx = 2;
        gbcPanelButtons.gridy = 0;
        gbcPanelButtons.insets = new Insets(25, 15, 20, 15);
        btnUpdate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        btnUpdate.setPreferredSize(new Dimension(100, 35));
        btnUpdate.setBorder(BorderFactory.createRaisedBevelBorder());
        btnUpdate.setBackground(new Color(254, 247, 34));
        btnUpdate.addActionListener(e -> {
            openUpdateWindow();});
        panelButtons.add(btnUpdate, gbcPanelButtons);

        //----------------------------------------------------------------------------
        GridBagConstraints gbcMain = new GridBagConstraints();

        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        add(panelDirections, gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 1;
        add(panelFields, gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 2;
        add(panelButtons, gbcMain);

        try {
            students = Database.selectStudents();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        idx = 0;
        updateFields();
    }

    public void updateFields()
    {
        try {
            students = Database.selectStudents();
            if(!students.isEmpty())
            {
                Student s = students.get(idx);
                tfId.setText(String.valueOf(s.getId()));
                tfName.setText(s.getName());
                tfSurname.setText(s.getSurname());
                tfAge.setText(String.valueOf(s.getAge()));
                tfAddress.setText(s.getAddress());
                tfEmail.setText(s.getEmail());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFieldsAfterInsert()
    {
        try {
            students = Database.selectStudents();
            idx = students.size() - 1;
            Student s = students.get(idx);
            tfId.setText(String.valueOf(s.getId()));
            tfName.setText(s.getName());
            tfSurname.setText(s.getSurname());
            tfAge.setText(String.valueOf(s.getAge()));
            tfAddress.setText(s.getAddress());
            tfEmail.setText(s.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFieldsAfterDelete()
    {
        try {
            students = Database.selectStudents();
            --idx;
            if (!students.isEmpty())
            {

                Student s = students.get(idx);
                tfId.setText(String.valueOf(s.getId()));
                tfName.setText(s.getName());
                tfSurname.setText(s.getSurname());
                tfAge.setText(String.valueOf(s.getAge()));
                tfAddress.setText(s.getAddress());
                tfEmail.setText(s.getEmail());
            }
            else
            {
                tfId.setText("");
                tfName.setText("");
                tfSurname.setText("");
                tfAge.setText("");
                tfAddress.setText("");
                tfEmail.setText("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public PanelRegistration getPanelRegistration() {
        return panelRegistration;
    }

    public void openInsertWindow()
    {
        JFrame frame = new JFrame("INSERT STUDENT");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        PanelInsertStudent panel = new PanelInsertStudent(this);
        panel.setVisible(true);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void openUpdateWindow()
    {
        JFrame frame = new JFrame("UPDATE STUDENT");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Student student = new Student(
                Integer.parseInt(tfId.getText()),
                tfName.getText(),
                tfSurname.getText(),
                Integer.parseInt(tfAge.getText()),
                tfAddress.getText(),
                tfEmail.getText()
        );
        PanelUpdateStudent panel = new PanelUpdateStudent(student, this);
        panel.setVisible(true);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

}
