package com.management.UI;

import com.management.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalUI extends JFrame {
    private JPanel mainPanel;
    private JMenuBar mbSistema;
    private JMenu mnFuncionarios;
    private JMenu mnEquipe;
    private JMenuItem miListarFuncionarios;
    private JMenuItem miCriarFuncinario;

    public PrincipalUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        miCriarFuncinario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        miListarFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args){

        Funcionario funcionario1 = new Funcionario("", 2, "");

        JFrame frame = new PrincipalUI("Tela Principal");
        frame.setVisible(true);
    }
}
