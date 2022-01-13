package com.management.View.Equipamento;

import com.management.Controller.Classes.Equipamento;
import com.management.View.PrincipalUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarNewEquipamentoFormUI extends JFrame{
    private JTextField tfNomeEquipamento;
    private JTextField txQuantidadeEquipamento;
    private JButton confirmarButton;
    private JPanel mainPanel;
    private PrincipalUI mainUI;

    public EditarNewEquipamentoFormUI(PrincipalUI principalUI, Equipamento equipamentoSelecionado){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeEquipamento = tfNomeEquipamento.getText();
                int quantidadeEquipamento = Integer.parseInt(txQuantidadeEquipamento.getText());
                editarInfoEquipamento(equipamentoSelecionado, nomeEquipamento, quantidadeEquipamento);
            }
        });
    }

    public EditarNewEquipamentoFormUI(PrincipalUI principalUI) {
    }

    private void editarInfoEquipamento(Equipamento equipamentoSelecionado, String nomeEquipamento, int quantidadeEquipamento){
        for(Equipamento umEquipamento : this.mainUI.getEquipamentos()){
            if(umEquipamento.getIdEquipamento() == equipamentoSelecionado.getIdEquipamento()){
                umEquipamento.setNomeEquipamento(nomeEquipamento);
                umEquipamento.setQntEquipamento(quantidadeEquipamento);
            }
        }
    }
}
