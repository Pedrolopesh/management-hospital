package com.management.UI.Funcionario;

import com.management.Funcionario;
import com.management.UI.PrincipalUI;

import javax.swing.*;

public class FuncionarioListaUI extends JFrame {
    private JPanel mainPanel;
    private JTextArea txTextShow;
    private PrincipalUI mainUI;


    public FuncionarioListaUI(PrincipalUI principalUI) {
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        for (Funcionario umFunc : this.mainUI.getFuncionarios()) {
            txTextShow.append(umFunc.toString());
            txTextShow.append("\n");
        }

    }
}