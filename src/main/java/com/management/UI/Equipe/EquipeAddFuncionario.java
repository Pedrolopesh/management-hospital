package com.management.UI.Equipe;

import com.management.Equipe;
import com.management.Funcionario;
import com.management.UI.PrincipalUI;

import javax.swing.*;
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

        for (Equipe umaEquipe: this.mainUI.getEquipes()){
            cbEquipes.addItem(umaEquipe);
        }

        for (Funcionario umFuncionaro: this.mainUI.getFuncionarios()){
            cbFuncionarios.addItem(umFuncionaro);
        }

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcionario selectFuncionario = cbFuncionarios.getItemAt(cbFuncionarios.getSelectedIndex());

                Equipe selectEquipe = cbEquipes.getItemAt(cbEquipes.getSelectedIndex());

                EquipeAddFuncionarioConfirmar(selectFuncionario, selectEquipe);
            }
        });
    }

    private void EquipeAddFuncionarioConfirmar(Funcionario funcionarioSelecionado, Equipe equipeSelecionada){
        this.mainUI.getEquipes();
    }
}
