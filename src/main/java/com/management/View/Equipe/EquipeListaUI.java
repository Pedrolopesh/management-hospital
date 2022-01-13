package com.management.View.Equipe;

import com.management.Controller.Classes.Equipe;
import com.management.View.PrincipalUI;

import javax.swing.*;

public class EquipeListaUI extends JFrame {
    private JPanel mainPanel;
    private PrincipalUI mainUI;
    private JTextArea txTextShow;

    public EquipeListaUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        for(Equipe umaEquipe: this.mainUI.getEquipes()){
            txTextShow.append(umaEquipe.imprimeFuncionarios());
            txTextShow.append("\n");
        }
    }
}
