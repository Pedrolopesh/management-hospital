package com.management.View.Equipe;

import com.management.Model.Classes.Equipe;
import com.management.Model.Classes.Excessao;
import com.management.Model.Classes.Funcionario;
import com.management.View.PrincipalUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipeAddFuncionario extends JFrame{
    private JPanel mainPanel;
    private JLabel mainLabel;
    private JComboBox<Equipe> cbEquipes;
    private JButton confirmarButton;
    private JLabel labelFuncioario;
    private JComboBox<Funcionario> cbFuncionarios;
    private PrincipalUI mainUI;

    public EquipeAddFuncionario(PrincipalUI principalUI){
        this.mainUI = principalUI;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setContentPane(mainPanel);
        mainPanel.setPreferredSize(new Dimension(600, 300));
        this.pack();

        for (Funcionario umFuncionaro: this.mainUI.getFuncionarios()){
            cbFuncionarios.addItem(umFuncionaro);
        }

        for (Equipe umaEquipe: this.mainUI.getEquipes()){
            cbEquipes.addItem(umaEquipe);
        }


        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Funcionario selectFuncionario = cbFuncionarios.getItemAt(cbFuncionarios.getSelectedIndex());
                    Equipe selectEquipe = cbEquipes.getItemAt(cbEquipes.getSelectedIndex());
                    EquipeAddFuncionarioConfirmar(selectFuncionario, selectEquipe);
                } catch (Excessao ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void EquipeAddFuncionarioConfirmar(Funcionario funcionarioSelecionado, Equipe equipeSelecionada) throws Excessao{
        for (Equipe umaEquipe: this.mainUI.getEquipes()){
            if(umaEquipe.getIdEquipe() == equipeSelecionada.getIdEquipe()){
                umaEquipe.addFuncionario(funcionarioSelecionado);
                funcionarioSelecionado.setStatusFuncionario("emEquipe");
                umaEquipe.setStatusEquipe("funcionarios");
            }
        }
    }
}
