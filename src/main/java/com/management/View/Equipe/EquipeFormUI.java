package com.management.View.Equipe;

import com.management.Controller.Classes.Equipe;
import com.management.Controller.Classes.Funcionario;
import com.management.View.PrincipalUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipeFormUI extends JFrame {
    private JPanel mainPanel;
    private JLabel labelNome;
    private JButton botaoSalvar;
    private JTextField tfNomeEquipe;
    private JComboBox<Funcionario> cbFuncionarios;
    private JLabel labelLiderEquipe;
    private PrincipalUI mainUI;

    public EquipeFormUI(PrincipalUI principalUI){
        this.mainUI = principalUI;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        for (Funcionario umFuncionario: this.mainUI.getFuncionarios()){
            cbFuncionarios.addItem(umFuncionario);
        }

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nextid = generateId();
                String nome = tfNomeEquipe.getText();
                Funcionario liderEquipe = cbFuncionarios.getItemAt(cbFuncionarios.getSelectedIndex());

                Equipe novaEquipe = new Equipe(nome, nextid, "vazio");
                novaEquipe.setLiderEquipe(liderEquipe.getNome());

                salvarEquipe(novaEquipe);
            }
        });
    }

    private int generateId(){
        int nextid = this.mainUI.getEquipes().size() + 1;;
        return nextid;
    }

    private void salvarEquipe(Equipe newEquipe){
        this.mainUI.getEquipes().add(newEquipe);
    }
}
