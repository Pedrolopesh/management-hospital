package com.management.View.Equipe;

import com.management.Controller.Classes.Equipe;
import com.management.View.Pesquisa.PesquisaUI;
import com.management.View.PrincipalUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipePesquisaUI extends JFrame{
    private JTextField txNomeEquipe;
    private JButton confirmarButton;
    private JPanel mainPanel;
    private PrincipalUI mainUI;

    public EquipePesquisaUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeEquipe = txNomeEquipe.getText();
                pesquisarEquipe(nomeEquipe);
            }
        });
    }

    private void pesquisarEquipe(String nomeEquipe){
        String resultado = "";

        for (Equipe umaEquiepe: this.mainUI.getEquipes()){
            if(umaEquiepe.getNomeEquipe().equals(nomeEquipe)){
                resultado = umaEquiepe.toString();
            }
        }

        PesquisaUI resultadoPesquisa = new PesquisaUI(resultado);
        resultadoPesquisa.setVisible(true);
    }

}
