package com.management.UI.UnidadeHospitalar;

import com.management.UI.PrincipalUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnidadeEquipeFormUI extends JFrame{
    private JPanel mainPanel;
    private JLabel labelUnidade;
    private JComboBox cbUnidade;
    private JLabel labelEquipe;
    private JComboBox cbEquipe;
    private JButton confirmarButton;
    private JLabel labelTitulo;
    private PrincipalUI mainUI;

    public UnidadeEquipeFormUI(PrincipalUI principalUI){
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
