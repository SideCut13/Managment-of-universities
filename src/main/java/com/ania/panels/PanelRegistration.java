package com.ania.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.ania.database.Database;
import com.ania.domain.Registration;
import com.ania.domain.Student;
import com.ania.domain.StudentUniversity;
import com.ania.domain.University;
import com.ania.models.CustomComboBoxModel;


public class PanelRegistration extends JPanel {

    //BUTTONS AND ID FIELD
    private JButton btnLeft = new JButton("      ");
    private JButton btnRight = new JButton("      ");
    private JTextField tfId = new JTextField(12);

    private JLabel lStudentId = new JLabel("STUDENT ID");
    private JLabel lUniversityId = new JLabel("UNIVERSITY ID");

    //REGISTRATION FIELDS
    private JLabel lStudentFee = new JLabel("STUDENT FEE");
    private JLabel lStudentYear = new JLabel("STUDENT YEAR");

    private JTextField tfStudentFee = new JTextField(15);
    private JTextField tfStudentYear = new JTextField(15);

    //REGISTRATION FIELDS 2
    private JLabel lStudentFee2 = new JLabel("STUDENT FEE");
    private JLabel lStudentYear2 = new JLabel("STUDENT YEAR");

    private JTextField tfStudentFee2 = new JTextField(15);
    //private JTextField tfStudentYear2 = new JTextField(10);
    private CustomComboBoxModel<Integer> modelCbStudentYear2;
    private JComboBox<Integer> cbStudentYear2;

    //STUDENT FIELDS
    private JLabel lStudentName = new JLabel("NAME");
    private JLabel lStudentSurname = new JLabel("SURNAME");
    private JLabel lStudentAge = new JLabel("AGE");
    private JLabel lStudentAddress = new JLabel("ADDRESS");
    private JLabel lStudentEmail = new JLabel("EMAIL");

    private JTextField tfStudentName = new JTextField(15);
    private JTextField tfStudentSurname = new JTextField(15);
    private JTextField tfStudentAge = new JTextField(15);
    private JTextField tfStudentAddress = new JTextField(15);
    private JTextField tfStudentEmail = new JTextField(15);

    //STUDENT FIELDS2
    private JLabel lStudentName2 = new JLabel("NAME");
    private JLabel lStudentSurname2 = new JLabel("SURNAME");
    private JLabel lStudentAge2 = new JLabel("AGE");
    private JLabel lStudentAddress2 = new JLabel("ADDRESS");
    private JLabel lStudentEmail2 = new JLabel("EMAIL");

    private JTextField tfStudentName2 = new JTextField(15);
    private JTextField tfStudentSurname2 = new JTextField(15);
    private JTextField tfStudentAge2 = new JTextField(15);
    private JTextField tfStudentAddress2 = new JTextField(15);
    private JTextField tfStudentEmail2 = new JTextField(15);

    //UNIVERSITY FIELDS
    private JLabel lUniversityName = new JLabel("NAME");
    private JLabel lUniversityCity = new JLabel("CITY");
    private JLabel lUniversityAddress = new JLabel("ADDRESS");
    private JLabel lUniversityEmail = new JLabel("EMAIL");
    private JLabel lUniversityTelephoneNumber = new JLabel("TELEPHONE");
    private JLabel lUniversityYear = new JLabel("YEAR");

    private JTextField tfUniversityName = new JTextField(15);
    private JTextField tfUniversityCity = new JTextField(15);
    private JTextField tfUniversityAddress = new JTextField(15);
    private JTextField tfUniversityEmail = new JTextField(15);
    private JTextField tfUniversityTelephoneNumber = new JTextField(15);
    private JTextField tfUniversityYear = new JTextField(15);

    //UNIVERSITY FIELDS 2
    private JLabel lUniversityName2 = new JLabel("NAME");
    private JLabel lUniversityCity2 = new JLabel("CITY");
    private JLabel lUniversityAddress2 = new JLabel("ADDRESS");
    private JLabel lUniversityEmail2 = new JLabel("EMAIL");
    private JLabel lUniversityTelephoneNumber2 = new JLabel("TELEPHONE");
    private JLabel lUniversityYear2 = new JLabel("YEAR");

    private JTextField tfUniversityName2 = new JTextField(15);
    private JTextField tfUniversityCity2 = new JTextField(15);
    private JTextField tfUniversityAddress2 = new JTextField(15);
    private JTextField tfUniversityEmail2 = new JTextField(15);
    private JTextField tfUniversityTelephoneNumber2 = new JTextField(15);
    private JTextField tfUniversityYear2 = new JTextField(15);

    private JButton btnInsert = new JButton("INSERT");
    private JButton btnDelete = new JButton("DELETE");


    private JComboBox<Integer> cbStudent;
    private CustomComboBoxModel<Integer> modelCbStudent;
    private JComboBox<Integer> cbUniversity;
    private CustomComboBoxModel<Integer> modelCbUniversity;

    private List<StudentUniversity> studentUniversityList;
    private int idx = 0;
    private PanelFilter panelFilter;

    public PanelRegistration(PanelFilter panelFilter) {
        super(new GridBagLayout());

        this.panelFilter = panelFilter;
        setBackground(new Color(254, 91, 172));

        JPanel panelDirections = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelDirections = new GridBagConstraints();
        panelDirections.setBackground(new Color(254, 91, 172));

        gbcPanelDirections.gridx = 0;
        gbcPanelDirections.gridy = 0;
        gbcPanelDirections.insets = new Insets(8, 10, 10, 10);
        btnLeft.setPreferredSize(new Dimension(90, 30));
        btnLeft.setBorder(BorderFactory.createRaisedBevelBorder());
        btnLeft.setBackground(new Color(254, 247, 34));
        btnLeft.addActionListener(e -> {
            --idx;
            if (idx < 0)
            {
                idx = studentUniversityList.size() - 1;
            }
            fillTopFields();
        });
        panelDirections.add(btnLeft, gbcPanelDirections);

        gbcPanelDirections.gridx = 1;
        gbcPanelDirections.gridy = 0;
        gbcPanelDirections.insets = new Insets(8, 10, 10, 10);
        tfId.setEditable(false);
        tfId.setBorder(BorderFactory.createLoweredBevelBorder());
        tfId.setBackground(new Color(255, 255, 255));
        panelDirections.add(tfId, gbcPanelDirections);

        gbcPanelDirections.gridx = 2;
        gbcPanelDirections.gridy = 0;
        gbcPanelDirections.insets = new Insets(8, 10, 10, 10);
        btnRight.setPreferredSize(new Dimension(90, 30));
        btnRight.setBorder(BorderFactory.createRaisedBevelBorder());
        btnRight.setBackground(new Color(254, 247, 34));
        btnRight.addActionListener(e -> {
            ++idx;
            if(idx >= studentUniversityList.size()){
                idx = 0;
            }
            fillTopFields();
        });
        panelDirections.add(btnRight, gbcPanelDirections);

        //-------------------------------STUDENT FIELDS-----------------------------------

        JPanel panelFields = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelFields = new GridBagConstraints();
        panelFields.setBackground(new Color(254, 91, 172));

        //STUDENT FEE TXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 0;
        gbcPanelFields.insets = new Insets(10, 10, 3, 10);
        lStudentFee.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lStudentFee, gbcPanelFields);
        //STUDENT FEE FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 0;
        tfStudentFee.setEditable(false);
        tfStudentFee.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentFee.setBackground(new Color(255, 255, 255));
        panelFields.add(tfStudentFee, gbcPanelFields);


        //NAME TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 1;
        gbcPanelFields.insets = new Insets(3, 10, 3, 10);
        lStudentName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lStudentName, gbcPanelFields);
        //NAME FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 1;
        tfStudentName.setEditable(false);
        tfStudentName.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentName.setBackground(new Color(255, 255, 255));
        panelFields.add(tfStudentName, gbcPanelFields);


        //SURNAME TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 2;
        gbcPanelFields.insets = new Insets(3, 10, 3, 10);
        lStudentSurname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lStudentSurname, gbcPanelFields);
        //SURNAME FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 2;
        tfStudentSurname.setEditable(false);
        tfStudentSurname.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentSurname.setBackground(new Color(255, 255, 255));
        panelFields.add(tfStudentSurname, gbcPanelFields);


        //AGE TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 3;
        gbcPanelFields.insets = new Insets(3, 10, 3, 10);
        lStudentAge.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lStudentAge, gbcPanelFields);
        //AGE FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 3;
        tfStudentAge.setEditable(false);
        tfStudentAge.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentAge.setBackground(new Color(255, 255, 255));
        panelFields.add(tfStudentAge, gbcPanelFields);


        //ADDRESS TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 4;
        gbcPanelFields.insets = new Insets(3, 10, 3, 10);
        lStudentAddress.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lStudentAddress, gbcPanelFields);
        //ADDRESS FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 4;
        tfStudentAddress.setEditable(false);
        tfStudentAddress.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentAddress.setBackground(new Color(255, 255, 255));
        panelFields.add(tfStudentAddress, gbcPanelFields);


        //EMAIL TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 5;
        gbcPanelFields.insets = new Insets(3, 10, 8, 10);
        lStudentEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lStudentEmail, gbcPanelFields);
        //EMAIL FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 5;
        tfStudentEmail.setEditable(false);
        tfStudentEmail.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentEmail.setBackground(new Color(255, 255, 255));
        panelFields.add(tfStudentEmail, gbcPanelFields);

        //--------------------------UNVERSITY FIELDS-----------------------------------------------
        gbcPanelFields.gridx = 2;
        gbcPanelFields.gridy = 0;
        gbcPanelFields.insets = new Insets(10, 10, 3, 10);
        lStudentYear.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lStudentYear, gbcPanelFields);

        gbcPanelFields.gridx = 3;
        gbcPanelFields.gridy = 0;
        tfStudentYear.setEditable(false);
        tfStudentYear.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentYear.setBackground(new Color(255, 255, 255));
        panelFields.add(tfStudentYear, gbcPanelFields);


        gbcPanelFields.gridx = 2;
        gbcPanelFields.gridy = 1;
        gbcPanelFields.insets = new Insets(3, 10, 3, 10);
        lUniversityName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lUniversityName, gbcPanelFields);

        gbcPanelFields.gridx = 3;
        gbcPanelFields.gridy = 1;
        tfUniversityName.setEditable(false);
        tfUniversityName.setBorder(BorderFactory.createLoweredBevelBorder());
        tfUniversityName.setBackground(new Color(255, 255, 255));
        panelFields.add(tfUniversityName, gbcPanelFields);

        gbcPanelFields.gridx = 2;
        gbcPanelFields.gridy = 2;
        gbcPanelFields.insets = new Insets(3, 10, 3, 10);
        lUniversityCity.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lUniversityCity, gbcPanelFields);

        gbcPanelFields.gridx = 3;
        gbcPanelFields.gridy = 2;
        tfUniversityCity.setEditable(false);
        tfUniversityCity.setBorder(BorderFactory.createLoweredBevelBorder());
        tfUniversityCity.setBackground(new Color(255, 255, 255));
        panelFields.add(tfUniversityCity, gbcPanelFields);

        gbcPanelFields.gridx = 2;
        gbcPanelFields.gridy = 3;
        gbcPanelFields.insets = new Insets(3, 10, 3, 10);
        lUniversityAddress.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lUniversityAddress, gbcPanelFields);

        gbcPanelFields.gridx = 3;
        gbcPanelFields.gridy = 3;
        tfUniversityAddress.setEditable(false);
        tfUniversityAddress.setBorder(BorderFactory.createLoweredBevelBorder());
        tfUniversityAddress.setBackground(new Color(255, 255, 255));
        panelFields.add(tfUniversityAddress, gbcPanelFields);

        gbcPanelFields.gridx = 2;
        gbcPanelFields.gridy = 4;
        gbcPanelFields.insets = new Insets(3, 10, 3, 10);
        lUniversityEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lUniversityEmail, gbcPanelFields);

        gbcPanelFields.gridx = 3;
        gbcPanelFields.gridy = 4;
        tfUniversityEmail.setEditable(false);
        tfUniversityEmail.setBorder(BorderFactory.createLoweredBevelBorder());
        tfUniversityEmail.setBackground(new Color(255, 255, 255));
        panelFields.add(tfUniversityEmail, gbcPanelFields);

        gbcPanelFields.gridx = 2;
        gbcPanelFields.gridy = 5;
        gbcPanelFields.insets = new Insets(3, 10, 3, 10);
        lUniversityTelephoneNumber.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lUniversityTelephoneNumber, gbcPanelFields);

        gbcPanelFields.gridx = 3;
        gbcPanelFields.gridy = 5;
        tfUniversityTelephoneNumber.setEditable(false);
        tfUniversityTelephoneNumber.setBorder(BorderFactory.createLoweredBevelBorder());
        tfUniversityTelephoneNumber.setBackground(new Color(255, 255, 255));
        panelFields.add(tfUniversityTelephoneNumber, gbcPanelFields);

        gbcPanelFields.gridx = 2;
        gbcPanelFields.gridy = 6;
        gbcPanelFields.insets = new Insets(3, 10, 8, 10);
        lUniversityYear.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lUniversityYear, gbcPanelFields);

        gbcPanelFields.gridx = 3;
        gbcPanelFields.gridy = 6;
        tfUniversityYear.setEditable(false);
        tfUniversityYear.setBorder(BorderFactory.createLoweredBevelBorder());
        tfUniversityYear.setBackground(new Color(255, 255, 255));
        panelFields.add(tfUniversityYear, gbcPanelFields);

        //-----------------------------BUTTON DELETE-------------------
        JPanel panelButtons = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelButtons = new GridBagConstraints();
        panelButtons.setBackground(new Color(254, 91, 172));

        gbcPanelButtons.gridx = 0;
        gbcPanelButtons.gridy = 0;
        gbcPanelButtons.insets = new Insets(8, 5, 10, 5);
        btnDelete.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        btnDelete.setPreferredSize(new Dimension(100, 35));
        btnDelete.setBorder(BorderFactory.createRaisedBevelBorder());
        btnDelete.setBackground(new Color(254, 247, 34));
        btnDelete.addActionListener(e -> {
            try {
                if (!tfId.getText().isEmpty())
                {
                    Database.deleteStudentUniversity(Integer.parseInt(tfId.getText()));
                    updateFieldsAfterDelete();
                }
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
        panelButtons.add(btnDelete, gbcPanelButtons);

        //---------------------------AGAIN STUDENT PANEL---------------------
        JPanel panelFields2 = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelFields2 = new GridBagConstraints();
        panelFields2.setBackground(new Color(254, 91, 172));

        try {

            modelCbStudent = new CustomComboBoxModel<>(Database.selectStudentsIds());
            cbStudent = new JComboBox<>(modelCbStudent); //widok
            cbStudent.addActionListener(e -> {
                fillStudentDown();
            });
            modelCbUniversity = new CustomComboBoxModel<>(Database.selectUniversityIds()); //model
            cbUniversity = new JComboBox<>(modelCbUniversity); //widok
            cbUniversity.addActionListener(e -> {
                fillUniversityDown();
            });
        } catch (SQLException e2) {
            e2.printStackTrace();
        }

        gbcPanelFields2.gridx = 0;
        gbcPanelFields2.gridy = 0;
        gbcPanelFields2.insets = new Insets(10, 10, 3, 10);
        lStudentId.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields2.add(lStudentId, gbcPanelFields2);

        gbcPanelFields2.gridx = 1;
        gbcPanelFields2.gridy = 0;
        cbStudent.setBorder(BorderFactory.createCompoundBorder());
        cbStudent.setBackground(new Color(255, 255, 255));
        panelFields2.add(cbStudent, gbcPanelFields2);

        //STUDENT FEE TXT
        gbcPanelFields2.gridx = 0;
        gbcPanelFields2.gridy = 1;
        gbcPanelFields2.insets = new Insets(3, 10, 3, 10);
        lStudentFee2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields2.add(lStudentFee2, gbcPanelFields2);
        //STUDENT FEE FIELD
        gbcPanelFields2.gridx = 1;
        gbcPanelFields2.gridy = 1;
        tfStudentFee2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentFee2.setBackground(new Color(255, 255, 255));
        panelFields2.add(tfStudentFee2, gbcPanelFields2);


        //NAME TEXT
        gbcPanelFields2.gridx = 0;
        gbcPanelFields2.gridy = 2;
        gbcPanelFields2.insets = new Insets(3, 10, 3, 10);
        lStudentName2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields2.add(lStudentName2, gbcPanelFields2);
        //NAME FIELD
        gbcPanelFields2.gridx = 1;
        gbcPanelFields2.gridy = 2;
        tfStudentName2.setEditable(false);
        tfStudentName2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentName2.setBackground(new Color(255, 255, 255));
        panelFields2.add(tfStudentName2, gbcPanelFields2);


        //SURNAME TEXT
        gbcPanelFields2.gridx = 0;
        gbcPanelFields2.gridy = 3;
        gbcPanelFields2.insets = new Insets(3, 10, 3, 10);
        lStudentSurname2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields2.add(lStudentSurname2, gbcPanelFields2);
        //SURNAME FIELD
        gbcPanelFields2.gridx = 1;
        gbcPanelFields2.gridy = 3;
        tfStudentSurname2.setEditable(false);
        tfStudentSurname2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentSurname2.setBackground(new Color(255, 255, 255));
        panelFields2.add(tfStudentSurname2, gbcPanelFields2);


        //AGE TEXT
        gbcPanelFields2.gridx = 0;
        gbcPanelFields2.gridy = 4;
        gbcPanelFields2.insets = new Insets(3, 10, 3, 10);
        lStudentAge2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields2.add(lStudentAge2, gbcPanelFields2);
        //AGE FIELD
        gbcPanelFields2.gridx = 1;
        gbcPanelFields2.gridy = 4;
        tfStudentAge2.setEditable(false);
        tfStudentAge2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentAge2.setBackground(new Color(255, 255, 255));
        panelFields2.add(tfStudentAge2, gbcPanelFields2);


        //ADDRESS TEXT
        gbcPanelFields2.gridx = 0;
        gbcPanelFields2.gridy = 5;
        gbcPanelFields2.insets = new Insets(3, 10, 3, 10);
        lStudentAddress2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields2.add(lStudentAddress2, gbcPanelFields2);
        //ADDRESS FIELD
        gbcPanelFields2.gridx = 1;
        gbcPanelFields2.gridy = 5;
        tfStudentAddress2.setEditable(false);
        tfStudentAddress2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentAddress2.setBackground(new Color(255, 255, 255));
        panelFields2.add(tfStudentAddress2, gbcPanelFields2);


        //EMAIL TEXT
        gbcPanelFields2.gridx = 0;
        gbcPanelFields2.gridy = 6;
        gbcPanelFields2.insets = new Insets(3, 10, 8, 10);
        lStudentEmail2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields2.add(lStudentEmail2, gbcPanelFields2);
        //EMAIL FIELD
        gbcPanelFields2.gridx = 1;
        gbcPanelFields2.gridy = 6;
        tfStudentEmail2.setEditable(false);
        tfStudentEmail2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentEmail2.setBackground(new Color(255, 255, 255));
        panelFields2.add(tfStudentEmail2, gbcPanelFields2);

        //--------------------------AGAIN UNVERSITY FIELDS-----------------------------------------------

        gbcPanelFields2.gridx = 2;
        gbcPanelFields2.gridy = 0;
        gbcPanelFields2.insets = new Insets(10, 10, 3, 10);
        lUniversityId.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields2.add(lUniversityId, gbcPanelFields2);

        gbcPanelFields2.gridx = 3;
        gbcPanelFields2.gridy = 0;
        cbUniversity.setBorder(BorderFactory.createCompoundBorder());
        cbUniversity.setBackground(new Color(255, 255, 255));
        panelFields2.add(cbUniversity, gbcPanelFields2);

        gbcPanelFields2.gridx = 2;
        gbcPanelFields2.gridy = 1;
        gbcPanelFields2.insets = new Insets(3, 10, 3, 10);
        lStudentYear2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields2.add(lStudentYear2, gbcPanelFields2);

        gbcPanelFields2.gridx = 3;
        gbcPanelFields2.gridy = 1;
        List<Integer> yearsList = new ArrayList<>();
        Collections.addAll(yearsList, 1, 2, 3, 4, 5);
        modelCbStudentYear2 = new CustomComboBoxModel<>(yearsList);
        cbStudentYear2 = new JComboBox<>(modelCbStudentYear2);
        //Border border = BorderFactory.createCompoundBorder();

        cbStudentYear2.setBorder(BorderFactory.createCompoundBorder());
        cbStudentYear2.setBackground(new Color(255, 255, 255));
        panelFields2.add(cbStudentYear2, gbcPanelFields2);


        gbcPanelFields2.gridx = 2;
        gbcPanelFields2.gridy = 2;
        gbcPanelFields2.insets = new Insets(3, 10, 3, 10);
        lUniversityName2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields2.add(lUniversityName2, gbcPanelFields2);

        gbcPanelFields2.gridx = 3;
        gbcPanelFields2.gridy = 2;
        tfUniversityName2.setEditable(false);
        tfUniversityName2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfUniversityName2.setBackground(new Color(255, 255, 255));
        panelFields2.add(tfUniversityName2, gbcPanelFields2);

        gbcPanelFields2.gridx = 2;
        gbcPanelFields2.gridy = 3;
        gbcPanelFields2.insets = new Insets(3, 10, 3, 10);
        lUniversityCity2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields2.add(lUniversityCity2, gbcPanelFields2);

        gbcPanelFields2.gridx = 3;
        gbcPanelFields2.gridy = 3;
        tfUniversityCity2.setEditable(false);
        tfUniversityCity2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfUniversityCity2.setBackground(new Color(255, 255, 255));
        panelFields2.add(tfUniversityCity2, gbcPanelFields2);

        gbcPanelFields2.gridx = 2;
        gbcPanelFields2.gridy = 4;
        gbcPanelFields2.insets = new Insets(3, 10, 3, 10);
        lUniversityAddress2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields2.add(lUniversityAddress2, gbcPanelFields2);

        gbcPanelFields2.gridx = 3;
        gbcPanelFields2.gridy = 4;
        tfUniversityAddress2.setEditable(false);
        tfUniversityAddress2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfUniversityAddress2.setBackground(new Color(255, 255, 255));
        panelFields2.add(tfUniversityAddress2, gbcPanelFields2);

        gbcPanelFields2.gridx = 2;
        gbcPanelFields2.gridy = 5;
        gbcPanelFields2.insets = new Insets(3, 10, 3, 10);
        lUniversityEmail2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields2.add(lUniversityEmail2, gbcPanelFields2);

        gbcPanelFields2.gridx = 3;
        gbcPanelFields2.gridy = 5;
        tfUniversityEmail2.setEditable(false);
        tfUniversityEmail2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfUniversityEmail2.setBackground(new Color(255, 255, 255));
        panelFields2.add(tfUniversityEmail2, gbcPanelFields2);

        gbcPanelFields2.gridx = 2;
        gbcPanelFields2.gridy = 6;
        gbcPanelFields2.insets = new Insets(3, 10, 3, 10);
        lUniversityTelephoneNumber2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields2.add(lUniversityTelephoneNumber2, gbcPanelFields2);

        gbcPanelFields2.gridx = 3;
        gbcPanelFields2.gridy = 6;
        tfUniversityTelephoneNumber2.setEditable(false);
        tfUniversityTelephoneNumber2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfUniversityTelephoneNumber2.setBackground(new Color(255, 255, 255));
        panelFields2.add(tfUniversityTelephoneNumber2, gbcPanelFields2);

        gbcPanelFields2.gridx = 2;
        gbcPanelFields2.gridy = 7;
        gbcPanelFields2.insets = new Insets(3, 10, 8, 10);
        lUniversityYear2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields2.add(lUniversityYear2, gbcPanelFields2);

        gbcPanelFields2.gridx = 3;
        gbcPanelFields2.gridy = 7;
        tfUniversityYear2.setEditable(false);
        tfUniversityYear2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfUniversityYear2.setBackground(new Color(255, 255, 255));
        panelFields2.add(tfUniversityYear2, gbcPanelFields2);

        //-----------------------------INSERT-------------------------------------
        JPanel panelButtons2 = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelButtons2 = new GridBagConstraints();
        panelButtons2.setBackground(new Color(254, 91, 172));

        gbcPanelButtons2.gridx = 0;
        gbcPanelButtons2.gridy = 0;
        gbcPanelButtons2.insets = new Insets(8, 10, 10, 5);
        btnInsert.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        btnInsert.setPreferredSize(new Dimension(100, 35));
        btnInsert.setBorder(BorderFactory.createRaisedBevelBorder());
        btnInsert.setBackground(new Color(254, 247, 34));
        btnInsert.addActionListener(e -> {
            insertStudentUniversity();
        });
        panelButtons2.add(btnInsert, gbcPanelButtons2);

        //------------------------------------- MAIN------------------------------
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

        gbcMain.gridx = 0;
        gbcMain.gridy = 3;
        add(panelFields2, gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 4;
        add(panelButtons2, gbcMain);

        //-------------------------FILL DATA LIST----------------------------------
        try {
            studentUniversityList = Database.selectInnerJoin();
            idx = 0;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    //filling top fields
    public void fillTopFields()
    {
        StudentUniversity su = studentUniversityList.get(idx);

        tfId.setText(String.valueOf(su.getId()));

        tfStudentFee.setText(String.valueOf(su.getStudentFee()));
        tfStudentName.setText(su.getStudentName());
        tfStudentSurname.setText(su.getSurname());
        tfStudentAge.setText(String.valueOf(su.getAge()));
        tfStudentAddress.setText(su.getStudentAddress());
        tfStudentEmail.setText(su.getStudentEmail());
        tfStudentYear.setText(String.valueOf(su.getStudentYear()));

        tfUniversityName.setText(su.getUniversityName());
        tfUniversityCity.setText(su.getCity());
        tfUniversityAddress.setText(su.getUniversityAddress());
        tfUniversityEmail.setText(su.getUniversityEmail());
        tfUniversityTelephoneNumber.setText(su.getTelephoneNumber());
        tfUniversityYear.setText(String.valueOf(su.getYear()));


    }

    //filling top fields
    public void fillStudentDown()
    {
        Student su;
        try {
            su = Database.selectStudentById((Integer)cbStudent.getSelectedItem());
            tfStudentName2.setText(su.getName());
            tfStudentSurname2.setText(su.getSurname());
            tfStudentAge2.setText(String.valueOf(su.getAge()));
            tfStudentAddress2.setText(su.getAddress());
            tfStudentEmail2.setText(su.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void fillUniversityDown()
    {
        University su;
        try {
            su = Database.selectUniversityById((Integer)cbUniversity.getSelectedItem());
            tfUniversityName2.setText(su.getName());
            tfUniversityCity2.setText(su.getCity());
            tfUniversityAddress2.setText(su.getAddress());
            tfUniversityEmail2.setText(su.getEmail());
            tfUniversityTelephoneNumber2.setText(su.getTelephoneNumber());
            tfUniversityYear2.setText(String.valueOf(su.getYear()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //get a studentyear2 combobox and studentfee2 textfield
    public void insertStudentUniversity()
    {
        if (tfStudentFee2.getText().matches("[0-9]+\\.[0-9]{1,2}"))
        {
            try {
                Database.insertWpis(new Registration(
                        0,
                        (Integer)cbStudent.getSelectedItem(),
                        (Integer)cbUniversity.getSelectedItem(),
                        Double.parseDouble(tfStudentFee2.getText()),
                        (Integer)cbStudentYear2.getSelectedItem())
                );

                studentUniversityList = Database.selectInnerJoin();
                idx = studentUniversityList.size() - 1;
                fillTopFields();
                panelFilter.updateFields();

            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,  "INCORRECT FEE VALUE !!!");
        }
    }
    public void updateFieldsAfterDelete()
    {
        try {
            studentUniversityList = Database.selectInnerJoin();
            --idx;
            if (!studentUniversityList.isEmpty())
            {

                StudentUniversity su = studentUniversityList.get(idx);
                tfId.setText(String.valueOf(su.getId()));
                tfStudentFee.setText(String.valueOf(su.getStudentFee()));
                tfStudentName.setText(su.getStudentName());
                tfStudentSurname.setText(su.getSurname());
                tfStudentAge.setText(String.valueOf(su.getAge()));
                tfStudentAddress.setText(su.getStudentAddress());
                tfStudentEmail.setText(su.getStudentEmail());
                tfStudentYear.setText(String.valueOf(su.getStudentYear()));
                tfUniversityName.setText(su.getUniversityName());
                tfUniversityCity.setText(su.getCity());
                tfUniversityAddress.setText(su.getUniversityAddress());
                tfUniversityEmail.setText(su.getUniversityEmail());
                tfUniversityTelephoneNumber.setText(su.getTelephoneNumber());
                tfUniversityYear.setText(String.valueOf(su.getYear()));

            }
            else
            {
                tfId.setText("");
                tfStudentFee.setText("");
                tfStudentName.setText("");
                tfStudentSurname.setText("");
                tfStudentAge.setText("");
                tfStudentAddress.setText("");
                tfStudentEmail.setText("");
                tfStudentYear.setText("");
                tfUniversityName.setText("");
                tfUniversityCity.setText("");
                tfUniversityAddress.setText("");
                tfUniversityEmail.setText("");
                tfUniversityTelephoneNumber.setText("");
                tfUniversityYear.setText("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateComboboxes()
    {
        try {
            modelCbStudent.update(Database.selectStudentsIds());
            modelCbUniversity.update(Database.selectUniversityIds());
            cbStudent.updateUI();
            cbUniversity.updateUI();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
