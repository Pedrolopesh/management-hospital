package com.management.UI;

import com.management.Funcionario;

import javax.swing.*;

public class FuncionarioListaUI extends JFrame{
    private JPanel mainPanel;
    private JTextArea txTextShow;
    private PrincipalUI principalUI;


    public FuncionarioListaUI(PrincipalUI principalUI){
        this.principalUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        for(Funcionario umFunc : this.principalUI.getFuncionarios()){
            txTextShow.append(umFunc.toString());
        }

    }

//    public static void main(String[] args){
//        JFrame frame = new FuncionarioListaUI();
//        frame.setVisible(true);
//    }
}
