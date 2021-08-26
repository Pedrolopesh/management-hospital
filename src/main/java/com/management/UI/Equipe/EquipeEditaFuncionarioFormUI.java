package com.management.UI.Equipe;

import com.management.Equipe;
import com.management.UI.PrincipalUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipeEditaFuncionarioFormUI extends JFrame{
    private JPanel mainPanel;
    private JComboBox<Equipe> cbEquipesFuncionario;
    private JButton confirmarButton;
    private PrincipalUI mainUI;

    public EquipeEditaFuncionarioFormUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        for (Equipe umaEquipe : this.mainUI.getEquipes()){
            if(umaEquipe.getStatusEquipe().equals("funcionarios")){
                cbEquipesFuncionario.addItem(umaEquipe);
            }
        }
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipe equipeSelecionada = cbEquipesFuncionario.getItemAt(cbEquipesFuncionario.getSelectedIndex());
                editarFuncionarioEmEquipe(equipeSelecionada);
            }
        });
    }

    public void editarFuncionarioEmEquipe(Equipe equipeSelecionada){
        EquipeEditaFuncionarioUI equipeEditaFuncionarioUI = new EquipeEditaFuncionarioUI(this.mainUI, equipeSelecionada);
        equipeEditaFuncionarioUI.setVisible(true);
    }

}
