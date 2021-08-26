package com.management.UI.Funcionario;

import com.management.Funcionario;
import com.management.UI.Pesquisa.PesquisaUI;
import com.management.UI.PrincipalUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PesquisaNomeFuncionario extends JFrame {
    private JTextField tfNomeFuncionario;
    private JButton button1;
    private JPanel mainPanel;
    private PrincipalUI mainUI;

    public PesquisaNomeFuncionario(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeFuncionario = tfNomeFuncionario.getText();

                pesquisarFuncionario(nomeFuncionario);
            }
        });
    }

    private void pesquisarFuncionario(String nomeFuncionario){
        String resultado = "";

        for (Funcionario umFuncionario: this.mainUI.getFuncionarios()){
            if(umFuncionario.getNome().equals(nomeFuncionario)){
                resultado = umFuncionario.toString();
            }
        }

        PesquisaUI resultadoPesquisa = new PesquisaUI(resultado);
        resultadoPesquisa.setVisible(true);
    }
}
