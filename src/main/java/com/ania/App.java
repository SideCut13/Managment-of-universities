package com.ania;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.JFrame;

import com.ania.database.Database;
import com.ania.domain.Student;
import com.ania.panels.PanelMain;


public class App
{
    public static void createAndShowGui()
    {
        JFrame frame = new JFrame("UNIVERSITIES MANAGEMENT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PanelMain panel = new PanelMain();
        panel.setVisible(true);
        frame.setContentPane(panel);
        frame.setJMenuBar(panel.createMenuBar());
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(214, 240, 248));
    }
    public static void main(String[] args) {
        try {
            Database.connect();
            Database.createTables();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        javax.swing.SwingUtilities.invokeLater(
                new Runnable()
                {
                    public void run()
                    {
                        createAndShowGui();
                    }
                }
        );
    }
}