package com.management.UI.Equipe;

import com.management.Equipe;
import com.management.Funcionario;
import com.management.UI.PrincipalUI;

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

                System.out.println("Nome: " + nome);
                System.out.println("lider Equipe: " + liderEquipe.getNome());

                Equipe newEquipe = new Equipe(nome, nextid, liderEquipe.getNome());
                salvarEquipe(newEquipe);
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
