package com.management.View.Equipe;

import com.management.Controller.Classes.Equipe;
import com.management.Controller.Classes.Funcionario;
import com.management.View.PrincipalUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipeEditaFuncionarioUI extends JFrame{
    private JPanel mainPanel;
    private JComboBox<Funcionario> cbFuncionariosEquipe;
    private JComboBox<Equipe> cbEquipes;
    private JButton confirmarButton;
    private PrincipalUI mainUI;

    public EquipeEditaFuncionarioUI(PrincipalUI principalUI, Equipe equipeSelecionada){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        for(Funcionario umFuncionario : this.mainUI.getFuncionarios()){
            cbFuncionariosEquipe.addItem(umFuncionario);
        }

        for(Equipe umaEquipe : this.mainUI.getEquipes()){
            cbEquipes.addItem(umaEquipe);
        }

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcionario funcionarioSelecionado = cbFuncionariosEquipe.getItemAt(cbFuncionariosEquipe.getSelectedIndex());
                Equipe novaEquipeSelescionada = cbEquipes.getItemAt(cbEquipes.getSelectedIndex());

                removerFuncionarioDaEquipe(funcionarioSelecionado, equipeSelecionada);
                adicionarFuncionarioNovaEquipe(funcionarioSelecionado, novaEquipeSelescionada);
            }
        });
    }

    private void removerFuncionarioDaEquipe(Funcionario funcionarioSelecionado, Equipe equipeSelecionada){
        equipeSelecionada.removeFuncionario(funcionarioSelecionado);
    }

    private void adicionarFuncionarioNovaEquipe(Funcionario funcionarioSelecionado, Equipe novaEquipeSelescionada){
        novaEquipeSelescionada.addFuncionario(funcionarioSelecionado);
    }

}
