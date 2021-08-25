package com.management.UI.UnidadeHospitalar;

import com.management.UI.PrincipalUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnidadeQuartoFormUI extends JFrame {
    private JPanel mainPanel;
    private JLabel labelTitulo;
    private JLabel labelUnidade;
    private JComboBox cbUnidades;
    private JLabel labelQuarto;
    private JComboBox cbQuartos;
    private JButton confirmarButton;
    private PrincipalUI mainUI;

    public UnidadeQuartoFormUI(PrincipalUI principalUI) {
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
