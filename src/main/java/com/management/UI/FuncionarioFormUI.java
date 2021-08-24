package com.management.UI;

import com.management.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionarioFormUI extends JFrame {
    private JPanel mainPanel;
    private JLabel nomeFuncionario;
    private JTextField nomeFuncionarioTextField;
    private JTextField telefoneFuncionarioTextField;
    private JLabel telefoneFuncionario;
    private JLabel cargoFuncionario;
    private JTextField cargoFuncionarioTextField;
    private JButton confirmarButton;
    private PrincipalUI functionariosUI;

    public FuncionarioFormUI(PrincipalUI principalUI){
        this.functionariosUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                //validar campos que foram preenchidos
                // se campos estiverem validos, fazer sets
                // se sets derem certo, mostrar mensagem que deu certo!
                System.out.println();
                Funcionario funcionario = new Funcionario(nomeFuncionario.getText(), 1, telefoneFuncionario.getText());
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new FuncionarioFormUI();
        frame.setVisible(true);
    }
}
