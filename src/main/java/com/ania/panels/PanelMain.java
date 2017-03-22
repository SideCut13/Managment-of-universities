package com.ania.panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PanelMain extends JPanel{
    private PanelStudent panelStudent;
    private PanelUniversity panelUniversity;
    private PanelRegistration panelRegistration;
    private PanelFilter panelFilter;

    private final String PANEL_STUDENT = "PANEL_STUDENT";
    private final String PANEL_UNIVERSITY = "PANEL_UNIVERSITY";
    private final String PANEL_REGISTRATION = "PANEL_REGISTRATION";
    private final String PANEL_FILTER = "PANEL_FILTER";

    public PanelMain()
    {
        super(new CardLayout());

        panelFilter = new PanelFilter();
        panelRegistration = new PanelRegistration(panelFilter);
        panelStudent = new PanelStudent(panelRegistration);
        panelUniversity = new PanelUniversity(panelRegistration);

        add(panelStudent,PANEL_STUDENT);
        add(panelUniversity,PANEL_UNIVERSITY);
        add(panelRegistration, PANEL_REGISTRATION);

    }

    public JMenuBar createMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(254, 247, 34));
        JMenu menuPanele = new JMenu("Panels");

        JMenuItem menuPanelStudent = new JMenuItem("Student");
        menuPanelStudent.setBackground(new Color(254, 247, 34));

        menuPanelStudent.addActionListener(e -> {
            CardLayout cl = (CardLayout)getLayout();
            cl.show(this, PANEL_STUDENT);
        });


        JMenuItem menuPanelUniversity = new JMenuItem("University");
        menuPanelUniversity.setBackground(new Color(254, 247, 34));
        menuPanelUniversity.addActionListener(e -> {
            CardLayout cl = (CardLayout)getLayout();
            cl.show(this, PANEL_UNIVERSITY);
        });

        JMenuItem menuPanelRegistration = new JMenuItem("Registration");
        menuPanelRegistration.setBackground(new Color(254, 247, 34));
        menuPanelRegistration.addActionListener(e -> {
            CardLayout cl = (CardLayout)getLayout();
            cl.show(this, PANEL_REGISTRATION);
        });

        JMenuItem menuPanelFilter = new JMenuItem("Filter");
        menuPanelFilter.setBackground(new Color(254, 247, 34));
        menuPanelFilter.addActionListener(e -> {
            JFrame frame = new JFrame("FILTER PANEL");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            PanelFilter panel = new PanelFilter();
            panel.setVisible(true);
            frame.setContentPane(panel);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.getContentPane().setBackground(new Color(254, 91, 172));
            frame.pack();
        });

        menuPanele.add(menuPanelStudent);
        menuPanele.addSeparator();
        menuPanele.add(menuPanelUniversity);
        menuPanele.addSeparator();
        menuPanele.add(menuPanelRegistration);
        menuPanele.addSeparator();
        menuPanele.add(menuPanelFilter);


        menuBar.add(menuPanele);

        return menuBar;
    }


}
