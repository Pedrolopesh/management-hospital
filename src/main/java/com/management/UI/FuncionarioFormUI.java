package com.management.UI;

import com.management.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FuncionarioFormUI extends JFrame {
    private JPanel mainPanel;
    private JLabel cargoFuncionario;
    private JLabel lbNomeFuncionario;
    private JLabel lbTelefoneFuncionario;

    private JTextField tfNomeFuncionario;
    private JTextField tftelefoneFuncionario;
    private JTextField tfCargoFuncionario;
    private JButton confirmarButton;
    private PrincipalUI mainUI;
    private ArrayList<Funcionario> funcionarios;

    public FuncionarioFormUI(PrincipalUI principalUIParam){
        this.mainUI = principalUIParam;
        this.funcionarios = new ArrayList<Funcionario>();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nextid = generateId();
                String nome = tfNomeFuncionario.getText();
                String telefone = tftelefoneFuncionario.getText();
                String cargo = tfCargoFuncionario.getText();

                Funcionario newFuncionario = new Funcionario(nome, nextid, telefone);
                newFuncionario.setCargo(cargo);
                salvaFuncionario(newFuncionario);
            }
        });
    }

    private int generateId(){
        int nextid = this.mainUI.getFuncionarios().size() + 1;;
        return nextid;
    }

    private void salvaFuncionario(Funcionario newFuncionario) {
        this.mainUI.getFuncionarios().add(newFuncionario);
    }

}
