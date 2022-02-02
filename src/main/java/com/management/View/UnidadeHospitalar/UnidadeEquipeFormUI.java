package com.management.View.UnidadeHospitalar;

import com.management.Model.Classes.Equipe;
import com.management.View.PrincipalUI;
import com.management.Model.Classes.UnidadeHospitalar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnidadeEquipeFormUI extends JFrame{
    private JPanel mainPanel;
    private JLabel labelUnidade;
    private JComboBox<UnidadeHospitalar> cbUnidade;
    private JLabel labelEquipe;
    private JComboBox<Equipe> cbEquipe;
    private JButton confirmarButton;
    private JLabel labelTitulo;
    private PrincipalUI mainUI;

    public UnidadeEquipeFormUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        for (UnidadeHospitalar unidadeHospitalar: this.mainUI.getUnidadeHospitalares()){
            cbUnidade.addItem(unidadeHospitalar);
        }

        for (Equipe umaEquipe: this.mainUI.getEquipes()){
            cbEquipe.addItem(umaEquipe);
        }

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UnidadeHospitalar unidadeSelecionada = cbUnidade.getItemAt(cbUnidade.getSelectedIndex());

                Equipe equipeSelecionada = cbEquipe.getItemAt(cbEquipe.getSelectedIndex());

                confirmarUnidadeaddEquipe(unidadeSelecionada, equipeSelecionada);
            }
        });
    }



    private void confirmarUnidadeaddEquipe(UnidadeHospitalar unidadeSelecionada, Equipe equipeSelecionada){
        for (UnidadeHospitalar unidadeHospitalar : this.mainUI.getUnidadeHospitalares()){
            if(unidadeHospitalar.getIdUnidadeHospitalar() == unidadeSelecionada.getIdUnidadeHospitalar()){
                unidadeHospitalar.addEquipe(equipeSelecionada);
            }
        }
    }
}
