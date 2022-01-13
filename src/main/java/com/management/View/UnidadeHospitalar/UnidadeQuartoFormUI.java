package com.management.View.UnidadeHospitalar;

import com.management.Controller.Classes.QuartoHospitalar;
import com.management.View.PrincipalUI;
import com.management.Controller.Classes.UnidadeHospitalar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnidadeQuartoFormUI extends JFrame {
    private JPanel mainPanel;
    private JLabel labelTitulo;
    private JLabel labelUnidade;
    private JComboBox<UnidadeHospitalar> cbUnidades;
    private JLabel labelQuarto;
    private JComboBox<QuartoHospitalar> cbQuartos;
    private JButton confirmarButton;
    private PrincipalUI mainUI;

    public UnidadeQuartoFormUI(PrincipalUI principalUI) {
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        for (UnidadeHospitalar unidadeHospitalar: this.mainUI.getUnidadeHospitalares()){
            cbUnidades.addItem(unidadeHospitalar);
        }

        for (QuartoHospitalar umQuarto: this.mainUI.getQuartos()){
            cbQuartos.addItem(umQuarto);
        }

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UnidadeHospitalar unidadeSelecionada = cbUnidades.getItemAt(cbUnidades.getSelectedIndex());

                QuartoHospitalar quartoSelecionado = cbQuartos.getItemAt(cbQuartos.getSelectedIndex());

                confirmarUnidadeAddQuarto(unidadeSelecionada, quartoSelecionado);
            }
        });
    }

    private void confirmarUnidadeAddQuarto(UnidadeHospitalar unidadeSelecionada, QuartoHospitalar quartoSelecionado){
        for (UnidadeHospitalar unidadeHospitalar : this.mainUI.getUnidadeHospitalares()){
            if(unidadeHospitalar.getIdUnidadeHospitalar() == unidadeSelecionada.getIdUnidadeHospitalar()){
                unidadeHospitalar.addQuartoHospitalar(quartoSelecionado);
            }
        }
    }
}
