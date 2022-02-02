package com.management.View.QuartoHospitalar;

import com.management.Model.Classes.QuartoHospitalar;
import com.management.View.PrincipalUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuartoFormUI extends JFrame{
    private JTextField tfNomeQuarto;
    private JLabel labelNumeroLeitos;
    private JTextField tfNumeroLeitos;
    private JButton confirmarButton;
    private JPanel mainPanel;
    private PrincipalUI mainUI;

    public QuartoFormUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = tfNomeQuarto.getText();
                int totalLeitos = Integer.parseInt(tfNumeroLeitos.getText());
                int nextid = generateId();

                QuartoHospitalar newQuartoHospitalar = new QuartoHospitalar(nome, nextid, totalLeitos);
                salvarQuarto(newQuartoHospitalar);
            }
        });
    }

    private int generateId(){
        int nextid = this.mainUI.getQuartos().size() + 1;
        return nextid;
    }

    private void salvarQuarto(QuartoHospitalar newQuartoHospitalar){
        this.mainUI.getQuartos().add(newQuartoHospitalar);
    }
}
