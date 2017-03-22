package com.ania.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ania.database.Database;
import com.ania.domain.University;

public class PanelUpdateUniversity extends JPanel{

    private JLabel lName = new JLabel("NAME");
    private JLabel lCity = new JLabel("CITY");
    private JLabel lAddress = new JLabel("ADDRESS");
    private JLabel lEmail = new JLabel("EMAIL");
    private JLabel lTelephoneNumber = new JLabel("TELEPHONE");
    private JLabel lYear = new JLabel("YEAR");

    private JTextField tfName = new JTextField(20);
    private JTextField tfCity = new JTextField(20);
    private JTextField tfAddress = new JTextField(20);
    private JTextField tfEmail = new JTextField(20);
    private JTextField tfTelephoneNumber = new JTextField(20);
    private JTextField tfYear = new JTextField(20);

    private JButton btnUpdate = new JButton("UPDATE");
    private JButton btnCancel = new JButton("CANCEL");


    private University university;
    private PanelUniversity panelUniversity;

    public PanelUpdateUniversity(University university, PanelUniversity panelUniversity){
        super(new GridBagLayout());
        this.university = university;
        this.panelUniversity = panelUniversity;

        setBackground(new Color(254, 91, 172));

        JPanel panelFields = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelFields = new GridBagConstraints();
        panelFields.setBackground(new Color(254, 91, 172));

        //NAME TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 0;
        gbcPanelFields.insets = new Insets(10, 10, 7, 10);
        lName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        panelFields.add(lName, gbcPanelFields);
        //NAME FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 0;
        tfName.setText(university.getName());
        tfName.setBorder(BorderFactory.createLoweredBevelBorder());
        panelFields.add(tfName, gbcPanelFields);

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 1;
        gbcPanelFields.insets = new Insets(7, 10, 7, 10);
        lCity.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        panelFields.add(lCity, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 1;
        tfCity.setText(university.getCity());
        tfCity.setBorder(BorderFactory.createLoweredBevelBorder());
        panelFields.add(tfCity, gbcPanelFields);

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 2;
        gbcPanelFields.insets = new Insets(7, 10, 7, 10);
        lAddress.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        panelFields.add(lAddress, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 2;
        tfAddress.setText(university.getAddress());
        tfAddress.setBorder(BorderFactory.createLoweredBevelBorder());
        panelFields.add(tfAddress, gbcPanelFields);

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 3;
        gbcPanelFields.insets = new Insets(7, 10, 7, 10);
        lEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        panelFields.add(lEmail, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 3;
        tfEmail.setText(university.getEmail());
        tfEmail.setBorder(BorderFactory.createLoweredBevelBorder());
        panelFields.add(tfEmail, gbcPanelFields);

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 4;
        gbcPanelFields.insets = new Insets(7, 10, 7, 10);
        lTelephoneNumber.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        panelFields.add(lTelephoneNumber, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 4;
        tfTelephoneNumber.setText(university.getTelephoneNumber());
        tfTelephoneNumber.setBorder(BorderFactory.createLoweredBevelBorder());
        panelFields.add(tfTelephoneNumber, gbcPanelFields);

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 5;
        gbcPanelFields.insets = new Insets(7, 10, 15, 10);
        lYear.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        panelFields.add(lYear, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 5;
        tfYear.setText(String.valueOf(university.getYear()));
        tfYear.setBorder(BorderFactory.createLoweredBevelBorder());
        panelFields.add(tfYear, gbcPanelFields);


        //---------------------------------------------BUTTONS------------------------------------------------

        JPanel panelButtons = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelButtons = new GridBagConstraints();
        panelButtons.setBackground(new Color(254, 91, 172));

        //UPDATE
        gbcPanelButtons.gridx = 0;
        gbcPanelButtons.gridy = 0;
        gbcPanelButtons.insets = new Insets(15, 10, 10, 30);
        btnUpdate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        btnUpdate.setPreferredSize(new Dimension(100, 35));
        btnUpdate.setBorder(BorderFactory.createRaisedBevelBorder());
        btnUpdate.setBackground(new Color(254, 247, 34));
        btnUpdate.addActionListener(e -> {
            try {
                Database.updateUniversity(new University(
                        university.getId(),
                        tfName.getText(),
                        tfCity.getText(),
                        tfAddress.getText(),
                        tfEmail.getText(),
                        tfTelephoneNumber.getText(),
                        Integer.parseInt(tfYear.getText())));
                panelUniversity.updateFields();
                JFrame frame = (JFrame)getRootPane().getParent();
                frame.dispose();
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
        panelButtons.add(btnUpdate, gbcPanelButtons);


        gbcPanelButtons.gridx = 1;
        gbcPanelButtons.gridy = 0;
        gbcPanelButtons.insets = new Insets(15, 30, 10, 5);
        btnCancel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        btnCancel.setPreferredSize(new Dimension(100, 35));
        btnCancel.setBorder(BorderFactory.createRaisedBevelBorder());
        btnCancel.setBackground(new Color(254, 247, 34));
        btnCancel.addActionListener(e -> {
            JFrame frame = (JFrame)getRootPane().getParent();
            frame.dispose();
        });
        panelButtons.add(btnCancel, gbcPanelButtons);

        //---------------------------------------------------------------
        GridBagConstraints gbcMain = new GridBagConstraints();

        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        add(panelFields, gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 1;
        add(panelButtons, gbcMain);

    }
}
