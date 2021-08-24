package com.management.UI;

import com.management.Equipe;
import com.management.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PrincipalUI extends JFrame {
    private JPanel mainPanel;
    private JMenuBar mbSistema;
    private JMenu mnFuncionarios;
    private JMenu mnEquipe;
    private JMenuItem miListarFuncionarios;
    private JMenuItem miCriarFuncinario;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Equipe> equipes;

    public PrincipalUI(String title){
        super(title);
        this.funcionarios = new ArrayList<Funcionario>();
        this.equipes = new ArrayList<Equipe>();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        miCriarFuncinario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FuncionarioFormUI funcionarioFormUI = new FuncionarioFormUI();
                funcionarioFormUI.setVisible(true);
            }
        });

        miListarFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FuncionarioListaUI funcionarioListaUI = new FuncionarioListaUI();
                funcionarioListaUI.setVisible(true);
            }
        });
    }

    public ArrayList getFuncionarios(){
        return this.funcionarios;
    }

    public static void main(String[] args){

        Funcionario funcionario1 = new Funcionario("", 2, "");

        JFrame frame = new PrincipalUI("Tela Principal");
        frame.setVisible(true);
    }
}
