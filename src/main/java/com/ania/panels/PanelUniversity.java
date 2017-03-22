package com.ania.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.TextField;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ania.database.Database;
import com.ania.domain.Student;
import com.ania.domain.University;

public class PanelUniversity extends JPanel{

    private JButton btnLeft = new JButton("      ");
    private JButton btnRight = new JButton("      ");
    private JTextField tfId = new JTextField(12);

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

    private JButton btnInsert = new JButton("INSERT");
    private JButton btnDelete = new JButton("DELETE");
    private JButton btnUpdate = new JButton("UPDATE");

    private List<University> universities;
    private int idx = 0;

    private PanelRegistration panelRegistration;

    public PanelUniversity(PanelRegistration panelRegistration) {
        super(new GridBagLayout());
        this.panelRegistration = panelRegistration;
        setBackground(new Color(254, 91, 172));

        JPanel panelDirections = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelDirections = new GridBagConstraints();
        panelDirections.setBackground(new Color(254, 91, 172));

        gbcPanelDirections.gridx = 0;
        gbcPanelDirections.gridy = 0;
        gbcPanelDirections.insets = new Insets(10, 15, 33, 15);
        btnLeft.setPreferredSize(new Dimension(90, 30));
        btnLeft.setBorder(BorderFactory.createRaisedBevelBorder());
        btnLeft.setBackground(new Color(254, 247, 34));
        btnLeft.addActionListener(e -> {
            --idx;
            if (idx < 0)
            {
                idx = universities.size() - 1;
            }
            updateFields();
        });
        panelDirections.add(btnLeft, gbcPanelDirections);

        gbcPanelDirections.gridx = 1;
        gbcPanelDirections.gridy = 0;
        gbcPanelDirections.insets = new Insets(10, 15, 33, 15);
        tfId.setEditable(false);
        tfId.setBorder(BorderFactory.createLoweredBevelBorder());
        tfId.setBackground(new Color(255, 255, 255));
        panelDirections.add(tfId, gbcPanelDirections);

        gbcPanelDirections.gridx = 2;
        gbcPanelDirections.gridy = 0;
        gbcPanelDirections.insets = new Insets(10, 15, 33, 15);
        btnRight.setPreferredSize(new Dimension(90, 30));
        btnRight.setBorder(BorderFactory.createRaisedBevelBorder());
        btnRight.setBackground(new Color(254, 247, 34));
        btnRight.addActionListener(e -> {
            ++idx;
            if(idx >= universities.size()){
                idx = 0;
            }
            updateFields();
        });
        panelDirections.add(btnRight, gbcPanelDirections);

        //---------------------------------------------------------------------------
        JPanel panelFields = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelFields = new GridBagConstraints();
        panelFields.setBackground(new Color(254, 91, 172));

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 0;
        gbcPanelFields.insets = new Insets(33, 10, 9, 10);
        lName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        panelFields.add(lName, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 0;
        tfName.setEditable(false);
        tfName.setBorder(BorderFactory.createLoweredBevelBorder());
        tfName.setBackground(new Color(255, 255, 255));
        panelFields.add(tfName, gbcPanelFields);

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 1;
        gbcPanelFields.insets = new Insets(9, 10, 9, 10);
        lCity.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        panelFields.add(lCity, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 1;
        tfCity.setEditable(false);
        tfCity.setBorder(BorderFactory.createLoweredBevelBorder());
        tfCity.setBackground(new Color(255, 255, 255));
        panelFields.add(tfCity, gbcPanelFields);

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 2;
        gbcPanelFields.insets = new Insets(9, 10, 9, 10);
        lAddress.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        panelFields.add(lAddress, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 2;
        tfAddress.setEditable(false);
        tfAddress.setBorder(BorderFactory.createLoweredBevelBorder());
        tfAddress.setBackground(new Color(255, 255, 255));
        panelFields.add(tfAddress, gbcPanelFields);

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 3;
        gbcPanelFields.insets = new Insets(9, 10, 9, 10);
        lEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        panelFields.add(lEmail, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 3;
        tfEmail.setEditable(false);
        tfEmail.setBorder(BorderFactory.createLoweredBevelBorder());
        tfEmail.setBackground(new Color(255, 255, 255));
        panelFields.add(tfEmail, gbcPanelFields);

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 4;
        gbcPanelFields.insets = new Insets(9, 10, 9, 10);
        lTelephoneNumber.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        panelFields.add(lTelephoneNumber, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 4;
        tfTelephoneNumber.setEditable(false);
        tfTelephoneNumber.setBorder(BorderFactory.createLoweredBevelBorder());
        tfTelephoneNumber.setBackground(new Color(255, 255, 255));
        panelFields.add(tfTelephoneNumber, gbcPanelFields);

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 5;
        gbcPanelFields.insets = new Insets(9, 10, 22, 10);
        lYear.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        panelFields.add(lYear, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 5;
        tfYear.setEditable(false);
        tfYear.setBorder(BorderFactory.createLoweredBevelBorder());
        tfYear.setBackground(new Color(255, 255, 255));
        panelFields.add(tfYear, gbcPanelFields);


        //---------------------------------------------------------------------------
        JPanel panelButtons = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelButtons = new GridBagConstraints();
        panelButtons.setBackground(new Color(254, 91, 172));

        gbcPanelButtons.gridx = 0;
        gbcPanelButtons.gridy = 0;
        gbcPanelButtons.insets = new Insets(22, 15, 20, 15);
        btnInsert.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        btnInsert.setPreferredSize(new Dimension(100, 35));
        btnInsert.setBorder(BorderFactory.createRaisedBevelBorder());
        btnInsert.setBackground(new Color(254, 247, 34));
        btnInsert.addActionListener(e -> {
            openInsertWindow();
        });
        panelButtons.add(btnInsert, gbcPanelButtons);

        gbcPanelButtons.gridx = 1;
        gbcPanelButtons.gridy = 0;
        gbcPanelButtons.insets = new Insets(22, 15, 20, 15);
        btnDelete.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        btnDelete.setPreferredSize(new Dimension(100, 35));
        btnDelete.setBorder(BorderFactory.createRaisedBevelBorder());
        btnDelete.setBackground(new Color(254, 247, 34));
        btnDelete.addActionListener(e -> {
            try {
                if (!tfId.getText().isEmpty())
                {
                    Database.deleteUniversity(Integer.parseInt(tfId.getText()));
                    updateFieldsAfterDelete();
                }
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
        panelButtons.add(btnDelete, gbcPanelButtons);

        gbcPanelButtons.gridx = 2;
        gbcPanelButtons.gridy = 0;
        gbcPanelButtons.insets = new Insets(22, 15, 20, 15);
        btnUpdate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        btnUpdate.setPreferredSize(new Dimension(100, 35));
        btnUpdate.setBorder(BorderFactory.createRaisedBevelBorder());
        btnUpdate.setBackground(new Color(254, 247, 34));
        btnUpdate.addActionListener(e -> {openUpdateWindow();});
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
            universities = Database.selectUniversity();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        idx = 0;
        updateFields();
    }

    public void updateFields()
    {
        try {
            universities = Database.selectUniversity();
            if(!universities.isEmpty())
            {
                University u = universities.get(idx);
                tfId.setText(String.valueOf(u.getId()));
                tfName.setText(u.getName());
                tfCity.setText(u.getCity());
                tfAddress.setText(u.getAddress());
                tfEmail.setText(u.getEmail());
                tfTelephoneNumber.setText(u.getTelephoneNumber());
                tfYear.setText(String.valueOf(u.getYear()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFieldsAfterInsert()
    {
        try {
            universities = Database.selectUniversity();
            idx = universities.size() - 1;
            University u = universities.get(idx);
            tfId.setText(String.valueOf(u.getId()));
            tfName.setText(u.getName());
            tfCity.setText(u.getCity());
            tfAddress.setText(u.getAddress());
            tfEmail.setText(u.getEmail());
            tfTelephoneNumber.setText(u.getTelephoneNumber());
            tfYear.setText(String.valueOf(u.getYear()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFieldsAfterDelete()
    {
        try {
            universities = Database.selectUniversity();
            --idx;
            if (!universities.isEmpty())
            {

                University u = universities.get(idx);
                tfId.setText(String.valueOf(u.getId()));
                tfName.setText(u.getName());
                tfCity.setText(u.getCity());
                tfAddress.setText(u.getAddress());
                tfEmail.setText(u.getEmail());
                tfTelephoneNumber.setText(u.getTelephoneNumber());
                tfYear.setText(String.valueOf(u.getYear()));
            }
            else
            {
                tfId.setText("");
                tfName.setText("");
                tfCity.setText("");
                tfAddress.setText("");
                tfEmail.setText("");
                tfTelephoneNumber.setText("");
                tfYear.setText("");
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
        JFrame frame = new JFrame("INSERT UNIVERSITY");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        PanelInsertUniversity panel = new PanelInsertUniversity(this);
        panel.setVisible(true);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void openUpdateWindow()
    {
        JFrame frame = new JFrame("UPDATE UNIVERSITY");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        University university = new University(
                Integer.parseInt(tfId.getText()),
                tfName.getText(),
                tfCity.getText(),
                tfAddress.getText(),
                tfEmail.getText(),
                tfTelephoneNumber.getText(),
                Integer.parseInt(tfYear.getText())
        );
        PanelUpdateUniversity panel = new PanelUpdateUniversity(university, this);
        panel.setVisible(true);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
