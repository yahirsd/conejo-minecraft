/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.yahirsd.conejo;

import com.yahirsd.conejo.view.WindowMain;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author yahirsd
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.setProperty("sun.awt.noerasebackground", "true");
        SwingUtilities.invokeLater(() -> {
            WindowMain wm = new WindowMain();
            JFrame jframe = new JFrame("Conejo");
            jframe.add(wm);
            jframe.setSize(700, 700);
            jframe.setVisible(true);
            jframe.setLocationRelativeTo(null);
            jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
