package com.management.View.Funcionario;

import com.management.Model.Classes.Funcionario;
import com.management.Model.Classes.FuncionarioComparator;
import com.management.View.PrincipalUI;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public class FuncionarioListaUI extends JFrame {
    private JPanel mainPanel;
    private JTextArea txTextShow;
    private PrincipalUI mainUI;


    public FuncionarioListaUI(PrincipalUI principalUI) {
        this.mainUI = principalUI;

        FuncionarioComparator comparator = new FuncionarioComparator();
        Collections.sort(this.mainUI.getFuncionarios(), comparator);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setContentPane(mainPanel);
        mainPanel.setPreferredSize(new Dimension(300, 300));
        this.pack();

        for (Funcionario umFunc : this.mainUI.getFuncionarios()) {
            txTextShow.append(umFunc.toString());
            txTextShow.append("\n");
        }

    }
}