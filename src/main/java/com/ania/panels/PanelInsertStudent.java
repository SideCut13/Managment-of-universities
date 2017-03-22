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
import com.ania.domain.Student;

public class PanelInsertStudent extends JPanel{

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
    private JButton btnCancel = new JButton("CANCEL");

    private PanelStudent panelStudent;

    public PanelInsertStudent(PanelStudent panelStudent) {
        super(new GridBagLayout());
        this.panelStudent = panelStudent;
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
        tfName.setBorder(BorderFactory.createLoweredBevelBorder());
        //tfName.setToolTipText("HEJ");
        panelFields.add(tfName, gbcPanelFields);


        //SURNAME TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 1;
        gbcPanelFields.insets = new Insets(7, 10, 7, 10);
        lSurname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        panelFields.add(lSurname, gbcPanelFields);
        // SURNAME FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 1;
        tfSurname.setBorder(BorderFactory.createLoweredBevelBorder());
        panelFields.add(tfSurname, gbcPanelFields);


        //AGE TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 2;
        gbcPanelFields.insets = new Insets(7, 10, 7, 10);
        lAge.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        panelFields.add(lAge, gbcPanelFields);
        //AGE FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 2;
        tfAge.setBorder(BorderFactory.createLoweredBevelBorder());
        panelFields.add(tfAge, gbcPanelFields);


        //ADDRESS TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 3;
        gbcPanelFields.insets = new Insets(7, 10, 7, 10);
        lAddress.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        panelFields.add(lAddress, gbcPanelFields);
        //ADDRESS FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 3;
        tfAddress.setBorder(BorderFactory.createLoweredBevelBorder());
        panelFields.add(tfAddress, gbcPanelFields);


        //EMAIL TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 4;
        gbcPanelFields.insets = new Insets(7, 10, 15, 10);
        lEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        panelFields.add(lEmail, gbcPanelFields);
        //EMAIL FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 4;
        tfEmail.setBorder(BorderFactory.createLoweredBevelBorder());
        panelFields.add(tfEmail, gbcPanelFields);


        //---------------------------------------------BUTTONS------------------------------------------------

        JPanel panelButtons = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelButtons = new GridBagConstraints();
        panelButtons.setBackground(new Color(254, 91, 172));

        //INSERT
        gbcPanelButtons.gridx = 0;
        gbcPanelButtons.gridy = 0;
        gbcPanelButtons.insets = new Insets(15, 10, 10, 23);
        btnInsert.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        btnInsert.setPreferredSize(new Dimension(100, 35));
        btnInsert.setBorder(BorderFactory.createRaisedBevelBorder());
        btnInsert.setBackground(new Color(254, 247, 34));
        btnInsert.addActionListener(e -> {
            try {
                Database.insertStudent(new Student(
                        0,
                        tfName.getText(),
                        tfSurname.getText(),
                        Integer.parseInt(tfAge.getText()),
                        tfAddress.getText(),
                        tfEmail.getText()));
                panelStudent.updateFieldsAfterInsert();
                panelStudent.getPanelRegistration().updateComboboxes();
                JFrame frame = (JFrame)getRootPane().getParent();
                frame.dispose();
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
        panelButtons.add(btnInsert, gbcPanelButtons);



        //CANCEL
        gbcPanelButtons.gridx = 1;
        gbcPanelButtons.gridy = 0;
        gbcPanelButtons.insets = new Insets(15, 23, 10, 5);
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
