package com.ania.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.ania.database.Database;
import com.ania.domain.StudentUniversity;
import com.ania.models.CustomComboBoxModel;
import com.ania.models.CustomJListModel;
import com.ania.models.CustomTableModel;

public class PanelFilter extends JPanel{
    private JTable jTable;
    private CustomTableModel customJTableModel;

    private JList<String> jList1;
    private JList<String> jList2;
    private JList<String> jList3;

    private CustomJListModel<String> customJList1Model;
    private CustomJListModel<String> customJList2Model;
    private CustomJListModel<String> customJList3Model;

    private JCheckBox jCheckBoxList1 = new JCheckBox();
    private JCheckBox jCheckBoxList2 = new JCheckBox();
    private JCheckBox jCheckBoxList3 = new JCheckBox();
    private JCheckBox jCheckBoxAge = new JCheckBox();

    private JLabel lStudentName = new JLabel("STUDENT NAME");
    private JLabel lStudentSurname = new JLabel("STUDENT SURNAME");
    private JLabel lUniversityCity = new JLabel("UNIVERSITY CITY");

    private JLabel lAgeFrom = new JLabel("AGE FROM");
    private JLabel lAgeTo = new JLabel("TO");

    private JButton btnFilter = new JButton("FILTER");
    private JButton btnReset = new JButton("RESET");

    private JComboBox<Integer> cbAgeFrom;
    private CustomComboBoxModel<Integer> modelCbAgeFrom;
    private JComboBox<Integer> cbAgeTo;
    private CustomComboBoxModel<Integer> modelCbAgeTo;

    public PanelFilter(){
        super(new GridBagLayout());
        setBackground(new Color(254, 91, 172));

        JPanel panelTable = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelTable = new GridBagConstraints();
        panelTable.setBackground(new Color(254, 91, 172));

        gbcPanelTable.gridx = 0;
        gbcPanelTable.gridy = 0;
        gbcPanelTable.insets = new Insets(8, 10, 8, 10);
        List<String> columnsNames = new ArrayList<>();
        Collections.addAll(columnsNames, "Sname", "Ssurname", "SAge",
                "SAddress", "SEmail", "Uname", "UCity", "UAddress", "UEmail", "UTelephone", "UYear",
                "SFee", "SYear");
        try {
            customJTableModel = new CustomTableModel(Database.selectInnerJoin(), columnsNames);
            jTable = new JTable(customJTableModel);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        jTable.setBackground(new Color(254, 247, 34));
        jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
        jTable.setFillsViewportHeight(true);
        panelTable.add(new JScrollPane(jTable), gbcPanelTable);

        //---------------------------------LABELS------------------------------
        JPanel panelLabel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelLabel = new GridBagConstraints();
        panelLabel.setBackground(new Color(254, 91, 172));

        gbcPanelLabel.gridx = 0;
        gbcPanelLabel.gridy = 0;
        gbcPanelLabel.insets = new Insets(30, 15, 10, 15);
        lStudentName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        panelLabel.add(lStudentName, gbcPanelLabel);

        gbcPanelLabel.gridx = 1;
        gbcPanelLabel.gridy = 0;
        gbcPanelLabel.insets = new Insets(30, 15, 10, 15);
        lStudentSurname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        panelLabel.add(lStudentSurname, gbcPanelLabel);

        gbcPanelLabel.gridx = 2;
        gbcPanelLabel.gridy = 0;
        gbcPanelLabel.insets = new Insets(30, 15, 10, 15);
        lUniversityCity.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        panelLabel.add(lUniversityCity, gbcPanelLabel);

        //---------------------------JCHECKBOXES AND LISTS---------------------
        JPanel panelCheckbox = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelCheckbox = new GridBagConstraints();
        panelCheckbox.setBackground(new Color(254, 91, 172));


        gbcPanelCheckbox.gridx = 0;
        gbcPanelCheckbox.gridy = 0;
        gbcPanelCheckbox.insets = new Insets(8, 10, 8, 10);
        panelCheckbox.add(jCheckBoxList1, gbcPanelCheckbox);

        gbcPanelCheckbox.gridx = 1;
        gbcPanelCheckbox.gridy = 0;
        gbcPanelCheckbox.insets = new Insets(8, 10, 8, 10);
        try {
            customJList1Model = new CustomJListModel<>(Database.selectInnerJoinStudentNames());
            jList1 = new JList<>(customJList1Model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        panelCheckbox.add(new JScrollPane(jList1), gbcPanelCheckbox);

        gbcPanelCheckbox.gridx = 2;
        gbcPanelCheckbox.gridy = 0;
        gbcPanelCheckbox.insets = new Insets(8, 10, 8, 10);
        panelCheckbox.add(jCheckBoxList2, gbcPanelCheckbox);

        gbcPanelCheckbox.gridx = 3;
        gbcPanelCheckbox.gridy = 0;
        gbcPanelCheckbox.insets = new Insets(8, 10, 8, 10);
        try {
            customJList2Model = new CustomJListModel<>(Database.selectInnerJoinStudentSurnames());
            jList2 = new JList<>(customJList2Model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        panelCheckbox.add(new JScrollPane(jList2), gbcPanelCheckbox);

        gbcPanelCheckbox.gridx = 4;
        gbcPanelCheckbox.gridy = 0;
        gbcPanelCheckbox.insets = new Insets(8, 10, 8, 10);
        panelCheckbox.add(jCheckBoxList3, gbcPanelCheckbox);

        gbcPanelCheckbox.gridx = 5;
        gbcPanelCheckbox.gridy = 0;
        gbcPanelCheckbox.insets = new Insets(8, 10, 8, 10);
        try {
            customJList3Model = new CustomJListModel<>(Database.selectInnerJoinUniversityCity());
            jList3 = new JList<>(customJList3Model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        panelCheckbox.add(new JScrollPane(jList3), gbcPanelCheckbox);


        //-------------------------------AGE FROM... TO .... --------------------------------
        JPanel panelAgeCheckbox = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelAgeCheckbox= new GridBagConstraints();
        panelAgeCheckbox.setBackground(new Color(254, 91, 172));

        gbcPanelAgeCheckbox.gridx = 0;
        gbcPanelAgeCheckbox.gridy = 0;
        gbcPanelAgeCheckbox.insets = new Insets(8, 10, 8, 10);
        panelAgeCheckbox.add(jCheckBoxAge, gbcPanelAgeCheckbox);

        gbcPanelAgeCheckbox.gridx = 1;
        gbcPanelAgeCheckbox.gridy = 0;
        gbcPanelAgeCheckbox.insets = new Insets(8, 10, 8, 10);
        lAgeFrom.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelAgeCheckbox.add(lAgeFrom, gbcPanelAgeCheckbox);

        gbcPanelAgeCheckbox.gridx = 2;
        gbcPanelAgeCheckbox.gridy = 0;
        gbcPanelAgeCheckbox.insets = new Insets(8, 10, 8, 10);
        try {
            modelCbAgeFrom = new CustomComboBoxModel<>(Database.selectInnerJoinStudentAges());
            cbAgeFrom = new JComboBox<>(modelCbAgeFrom);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        panelAgeCheckbox.add(cbAgeFrom, gbcPanelAgeCheckbox);


        gbcPanelAgeCheckbox.gridx = 3;
        gbcPanelAgeCheckbox.gridy = 0;
        gbcPanelAgeCheckbox.insets = new Insets(8, 10, 8, 10);
        lAgeTo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        panelAgeCheckbox.add(lAgeTo, gbcPanelAgeCheckbox);

        gbcPanelAgeCheckbox.gridx = 4;
        gbcPanelAgeCheckbox.gridy = 0;
        gbcPanelAgeCheckbox.insets = new Insets(8, 10, 8, 10);
        try {
            modelCbAgeTo = new CustomComboBoxModel<>(Database.selectInnerJoinStudentAges());
            cbAgeTo = new JComboBox<>(modelCbAgeTo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        panelAgeCheckbox.add(cbAgeTo, gbcPanelAgeCheckbox);


        //----------------------------BUTTONS-----------------------------------

        JPanel panelButtons = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelButtons = new GridBagConstraints();
        panelButtons.setBackground(new Color(254, 91, 172));

        gbcPanelButtons.gridx = 0;
        gbcPanelButtons.gridy = 0;
        gbcPanelButtons.insets = new Insets(8, 10, 8, 5);
        btnFilter.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
        btnFilter.setPreferredSize(new Dimension(80, 25));
        btnFilter.setBorder(BorderFactory.createRaisedBevelBorder());
        btnFilter.setBackground(new Color(254, 247, 34));
        btnFilter.addActionListener(e -> {
            boolean isName = jCheckBoxList1.isSelected();
            boolean isSurname = jCheckBoxList2.isSelected();
            boolean isCity = jCheckBoxList3.isSelected();
            boolean isAge = jCheckBoxAge.isSelected();

            List<String> studentNameList = jList1.getSelectedValuesList();
            List<String> studentSurnameList = jList2.getSelectedValuesList();
            List<String> universityCityList = jList3.getSelectedValuesList();

            int ageFrom = (int)cbAgeFrom.getSelectedItem();
            int ageTo = (int)cbAgeTo.getSelectedItem();

            try {
                customJTableModel.update(Database.filterInnerJoin(isName, isSurname, isCity, isAge, false, studentNameList, studentSurnameList, universityCityList, ageFrom, ageTo, 0, 0));
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            jTable.updateUI();
        });
        panelButtons.add(btnFilter, gbcPanelButtons);


        gbcPanelButtons.gridx = 1;
        gbcPanelButtons.gridy = 0;
        gbcPanelButtons.insets = new Insets(8, 10, 8, 5);
        btnReset.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
        btnReset.setPreferredSize(new Dimension(80, 25));
        btnReset.setBorder(BorderFactory.createRaisedBevelBorder());
        btnReset.setBackground(new Color(254, 247, 34));
        btnReset.addActionListener(e -> {
            try {
                customJTableModel.update(Database.selectInnerJoin());
                jTable.updateUI();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
        panelButtons.add(btnReset, gbcPanelButtons);


        //--------------------------MAIN PANEL DIRECTIONS------------------------

        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        add(panelTable, gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 1;
        add(panelLabel, gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 2;
        add(panelCheckbox, gbcMain);


        gbcMain.gridx = 0;
        gbcMain.gridy = 3;
        add(panelAgeCheckbox, gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 4;
        add(panelButtons, gbcMain);
		/*
		gbcMain.gridx = 0;
		gbcMain.gridy = 5;
		add(panelButtons2, gbcMain);
		*/
    }

    public void updateFields()
    {
        try {
            customJTableModel.update(Database.selectInnerJoin());
            customJList1Model.update(Database.selectInnerJoinStudentNames());
            customJList2Model.update(Database.selectInnerJoinStudentSurnames());
            customJList3Model.update(Database.selectInnerJoinUniversityCity());
            modelCbAgeFrom.update(Database.selectInnerJoinStudentAges());
            modelCbAgeTo.update(Database.selectInnerJoinStudentAges());

            jTable.updateUI();
            jList1.updateUI();
            jList2.updateUI();
            jList3.updateUI();
            cbAgeFrom.updateUI();
            cbAgeTo.updateUI();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
