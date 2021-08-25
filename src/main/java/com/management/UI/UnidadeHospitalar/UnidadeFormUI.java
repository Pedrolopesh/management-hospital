package com.management.UI.UnidadeHospitalar;

import com.management.UI.PrincipalUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnidadeFormUI extends JFrame {
    private JLabel labelEspecialidade;
    private JLabel labelNomeUnidade;
    private JTextField textField1;
    private JComboBox cbEspecialidades;
    private JButton salvarButton;
    private JPanel mainPanel;
    private PrincipalUI mainUI;

    public UnidadeFormUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private int generateId(){
        int nextid = this.mainUI.getUnidadeHospitalares().size() + 1;
        return nextid;
    }
}
