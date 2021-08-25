package com.management.UI.Equipe;

import com.management.Equipe;
import com.management.UI.PrincipalUI;

import javax.swing.*;

public class EquipeAddFuncionario extends JFrame{
    private JPanel mainPanel;
    private JLabel mainLabel;
    private JComboBox cbEquipes;
    private JButton button1;
    private PrincipalUI mainUI;

    public EquipeAddFuncionario(PrincipalUI principalUI){
        this.mainUI = principalUI;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        for (Equipe umaEquipe: this.mainUI.getEquipes()){
            cbEquipes.addItem(umaEquipe);
        }
    }
}
