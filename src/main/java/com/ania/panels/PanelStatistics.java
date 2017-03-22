package com.ania.panels;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ania.models.CustomComboBoxModel;

public class PanelStatistics extends JPanel{
    private JLabel lMaxStudentAge = new JLabel("MAX STUDENT AGE");
    private JLabel lMinStudentAge = new JLabel("MIN STUDENT AGE");
    private JLabel lOldestUniversity = new JLabel("OLDEST UNIVERSITY");
    private JLabel lStudentsInCities = new JLabel("STUDENTS IN CITIES");
    private JLabel lSudentsAverageAge = new JLabel("STUDENTS AVERAGE AGE IN CITIES");
    private JLabel lOldestStudent = new JLabel("OLDEST STUDENT IN CITIES");

    private JTextField tfMaxStudentAge = new JTextField(10);
    private JTextField tfMinStudentAge = new JTextField(10);
    private JTextField tfOldestUniversity = new JTextField(10);

    private JComboBox<Integer> cbStudent;
    private CustomComboBoxModel<Integer> modelCbStudent;
    private JComboBox<Integer> cbUniversity;
    private CustomComboBoxModel<Integer> modelCbUniversity;

    public PanelStatistics(){

    }
}
