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
import com.ania.database.DatabaseDao;
import com.ania.database.DatabaseDaoImpl;
import com.ania.domain.Student;

public class PanelInsertRegistration extends JPanel {

    //REGISTRATION FIELDS 2
    private JLabel lStudentFee2 = new JLabel("Student fee");
    private JLabel lStudentYear2 = new JLabel("Student year");

    private JTextField tfStudentFee2 = new JTextField(10);
    private JTextField tfStudentYear2 = new JTextField(10);

    //STUDENT FIELDS2
    private JLabel lStudentName2 = new JLabel("Name");
    private JLabel lStudentSurname2 = new JLabel("Surname");
    private JLabel lStudentAge2 = new JLabel("Age");
    private JLabel lStudentAddress2 = new JLabel("Address");
    private JLabel lStudentEmail2 = new JLabel("Email");

    private JTextField tfStudentName2 = new JTextField(10);
    private JTextField tfStudentSurname2 = new JTextField(10);
    private JTextField tfStudentAge2 = new JTextField(10);
    private JTextField tfStudentAddress2 = new JTextField(10);
    private JTextField tfStudentEmail2 = new JTextField(10);


    //UNIVERSITY FIELDS 2
    private JLabel lUniversityName2 = new JLabel("Name");
    private JLabel lUniversityCity2 = new JLabel("City");
    private JLabel lUniversityAddress2 = new JLabel("Address");
    private JLabel lUniversityEmail2 = new JLabel("Email");
    private JLabel lUniversityTelephoneNumber2 = new JLabel("Telephone number");
    private JLabel lUniversityYear2 = new JLabel("Year");

    private JTextField tfUniversityName2 = new JTextField(10);
    private JTextField tfUniversityCity2 = new JTextField(10);
    private JTextField tfUniversityAddress2 = new JTextField(10);
    private JTextField tfUniversityEmail2 = new JTextField(10);
    private JTextField tfUniversityTelephoneNumber2 = new JTextField(10);
    private JTextField tfUniversityYear2 = new JTextField(10);

    private JButton btnInsert = new JButton("INSERT");
    private JButton btnCancel = new JButton("CANCEL");

    private PanelRegistration panelRegistration;

    private DatabaseDao databaseDao;

    public PanelInsertRegistration(PanelRegistration panelRegistration) {
        this.panelRegistration = panelRegistration;
        databaseDao = DatabaseDaoImpl.getInstance();

        setBackground(new Color(254, 91, 172));

        JPanel panelFields = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelFields = new GridBagConstraints();
        panelFields.setBackground(new Color(254, 91, 172));


        //STUDENT FEE TXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 0;
        gbcPanelFields.insets = new Insets(8, 10, 3, 10);
        lStudentFee2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lStudentFee2, gbcPanelFields);
        //STUDENT FEE FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 0;
        tfStudentFee2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentFee2.setBackground(new Color(255, 255, 255));
        panelFields.add(tfStudentFee2, gbcPanelFields);


        //NAME TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 1;
        gbcPanelFields.insets = new Insets(3, 10, 3, 10);
        lStudentName2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lStudentName2, gbcPanelFields);
        //NAME FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 1;
        tfStudentName2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentName2.setBackground(new Color(255, 255, 255));
        panelFields.add(tfStudentName2, gbcPanelFields);


        //SURNAME TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 2;
        gbcPanelFields.insets = new Insets(3, 10, 3, 10);
        lStudentSurname2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lStudentSurname2, gbcPanelFields);
        //SURNAME FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 2;
        tfStudentSurname2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentSurname2.setBackground(new Color(255, 255, 255));
        panelFields.add(tfStudentSurname2, gbcPanelFields);


        //AGE TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 3;
        gbcPanelFields.insets = new Insets(3, 10, 3, 10);
        lStudentAge2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lStudentAge2, gbcPanelFields);
        //AGE FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 3;
        tfStudentAge2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentAge2.setBackground(new Color(255, 255, 255));
        panelFields.add(tfStudentAge2, gbcPanelFields);


        //ADDRESS TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 4;
        gbcPanelFields.insets = new Insets(3, 10, 3, 10);
        lStudentAddress2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lStudentAddress2, gbcPanelFields);
        //ADDRESS FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 4;
        tfStudentAddress2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentAddress2.setBackground(new Color(255, 255, 255));
        panelFields.add(tfStudentAddress2, gbcPanelFields);


        //EMAIL TEXT
        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 5;
        gbcPanelFields.insets = new Insets(3, 10, 8, 10);
        lStudentEmail2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lStudentEmail2, gbcPanelFields);
        //EMAIL FIELD
        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 5;
        tfStudentEmail2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentEmail2.setBackground(new Color(255, 255, 255));
        panelFields.add(tfStudentEmail2, gbcPanelFields);

        //--------------------------AGAIN UNVERSITY FIELDS-----------------------------------------------
        gbcPanelFields.gridx = 2;
        gbcPanelFields.gridy = 0;
        gbcPanelFields.insets = new Insets(8, 10, 3, 10);
        lStudentYear2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lStudentYear2, gbcPanelFields);

        gbcPanelFields.gridx = 3;
        gbcPanelFields.gridy = 0;
        tfStudentYear2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfStudentYear2.setBackground(new Color(255, 255, 255));
        panelFields.add(tfStudentYear2, gbcPanelFields);


        gbcPanelFields.gridx = 2;
        gbcPanelFields.gridy = 1;
        gbcPanelFields.insets = new Insets(8, 10, 3, 10);
        lUniversityName2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lUniversityName2, gbcPanelFields);

        gbcPanelFields.gridx = 3;
        gbcPanelFields.gridy = 1;
        tfUniversityName2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfUniversityName2.setBackground(new Color(255, 255, 255));
        panelFields.add(tfUniversityName2, gbcPanelFields);

        gbcPanelFields.gridx = 2;
        gbcPanelFields.gridy = 2;
        gbcPanelFields.insets = new Insets(3, 10, 3, 10);
        lUniversityCity2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lUniversityCity2, gbcPanelFields);

        gbcPanelFields.gridx = 3;
        gbcPanelFields.gridy = 2;
        tfUniversityCity2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfUniversityCity2.setBackground(new Color(255, 255, 255));
        panelFields.add(tfUniversityCity2, gbcPanelFields);

        gbcPanelFields.gridx = 2;
        gbcPanelFields.gridy = 3;
        gbcPanelFields.insets = new Insets(3, 10, 3, 10);
        lUniversityAddress2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lUniversityAddress2, gbcPanelFields);

        gbcPanelFields.gridx = 3;
        gbcPanelFields.gridy = 3;
        tfUniversityAddress2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfUniversityAddress2.setBackground(new Color(255, 255, 255));
        panelFields.add(tfUniversityAddress2, gbcPanelFields);

        gbcPanelFields.gridx = 2;
        gbcPanelFields.gridy = 4;
        gbcPanelFields.insets = new Insets(3, 10, 3, 10);
        lUniversityEmail2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lUniversityEmail2, gbcPanelFields);

        gbcPanelFields.gridx = 3;
        gbcPanelFields.gridy = 4;
        tfUniversityEmail2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfUniversityEmail2.setBackground(new Color(255, 255, 255));
        panelFields.add(tfUniversityEmail2, gbcPanelFields);

        gbcPanelFields.gridx = 2;
        gbcPanelFields.gridy = 5;
        gbcPanelFields.insets = new Insets(3, 10, 3, 10);
        lUniversityTelephoneNumber2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lUniversityTelephoneNumber2, gbcPanelFields);

        gbcPanelFields.gridx = 3;
        gbcPanelFields.gridy = 5;
        tfUniversityTelephoneNumber2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfUniversityTelephoneNumber2.setBackground(new Color(255, 255, 255));
        panelFields.add(tfUniversityTelephoneNumber2, gbcPanelFields);

        gbcPanelFields.gridx = 2;
        gbcPanelFields.gridy = 6;
        gbcPanelFields.insets = new Insets(3, 10, 8, 10);
        lUniversityYear2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelFields.add(lUniversityYear2, gbcPanelFields);

        gbcPanelFields.gridx = 3;
        gbcPanelFields.gridy = 6;
        tfUniversityYear2.setBorder(BorderFactory.createLoweredBevelBorder());
        tfUniversityYear2.setBackground(new Color(255, 255, 255));
        panelFields.add(tfUniversityYear2, gbcPanelFields);



        //---------------------------------------------BUTTONS------------------------------------------------


        GridBagConstraints gbcPanelButtons = new GridBagConstraints();

        //INSERT
        gbcPanelButtons.gridx = 0;
        gbcPanelButtons.gridy = 5;
        gbcPanelButtons.insets = new Insets(8, 22, 8, 15);
        btnInsert.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
        btnInsert.setPreferredSize(new Dimension(80, 25));
        btnInsert.setBorder(BorderFactory.createRaisedBevelBorder());
        btnInsert.setBackground(new Color(254, 247, 34));
		/*btnInsert.addActionListener(e -> {
			try {
				Database.insertStudent(new Student(
						0,
						tfName.getText(),
						tfSurname.getText(),
						Integer.parseInt(tfAge.getText()),
						tfAddress.getText(),
						tfEmail.getText()));
				panelStudent.updateFieldsAfterInsert();
				JFrame frame = (JFrame)getRootPane().getParent();
				frame.dispose();
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		*/
        panelFields.add(btnInsert, gbcPanelButtons);



        //CANCEL
        gbcPanelButtons.gridx = 1;
        gbcPanelButtons.gridy = 5;
        gbcPanelButtons.insets = new Insets(8, 15, 8, 7);
        btnCancel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
        btnCancel.setPreferredSize(new Dimension(80, 25));
        btnCancel.setBorder(BorderFactory.createRaisedBevelBorder());
        btnCancel.setBackground(new Color(254, 247, 34));
        btnCancel.addActionListener(e -> {
            JFrame frame = (JFrame)getRootPane().getParent();
            frame.dispose();
        });
        panelFields.add(btnCancel, gbcPanelButtons);

        add(panelFields);
    }

}
