package com.management;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionarioUI extends JFrame {
    private JPanel mainPanel;
    private JLabel nomeFuncionario;
    private JTextField nomeFuncionarioTextField;
    private JTextField telefoneFuncionarioTextField;
    private JLabel telefoneFuncionario;
    private JLabel cargoFuncionario;
    private JTextField cargoFuncionarioTextField;
    private JButton confirmarButton;

    public FuncionarioUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                //validar campos que foram preenchidos
                // se campos estiverem validos, fazer sets
                // se sets derem certo, mostrar mensagem que deu certo!
                Funcionario funcionario = new Funcionario(nomeFuncionario.getText(), 1, telefoneFuncionario.getText());
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new FuncionarioUI("Hello World");
        frame.setVisible(true);
    }
}
