package com.management.UI.Equipe;

import com.management.Equipe;
import com.management.Funcionario;
import com.management.UI.Pesquisa.PesquisaUI;
import com.management.UI.PrincipalUI;

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
