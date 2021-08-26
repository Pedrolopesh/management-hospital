package com.management.UI.Funcionario;

import com.management.Funcionario;
import com.management.UI.PrincipalUI;

import javax.swing.*;
import java.awt.*;
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
// Construtor
    public FuncionarioFormUI(PrincipalUI principalUIParam){
        this.mainUI = principalUIParam;
        this.funcionarios = new ArrayList<Funcionario>();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(600, 600));
        mainPanel.repaint();
        this.setContentPane(mainPanel);

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
