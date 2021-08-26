package com.management.UI.Equipamento;

import com.management.Equipamento;
import com.management.UI.PrincipalUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipamentoFormEditarUI extends JFrame {
    private JComboBox<Equipamento> cbEquipamentos;
    private JButton confirmarButton;
    private JPanel mainPanel;
    private PrincipalUI mainUI;

    public EquipamentoFormEditarUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        for(Equipamento umEquipamento : this.mainUI.getEquipamentos()){
            cbEquipamentos.addItem(umEquipamento);
        }

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipamento equipamentoSelecionado = cbEquipamentos.getItemAt(cbEquipamentos.getSelectedIndex());
                navegarParaFormularioEditar(equipamentoSelecionado);
            }
        });

    }

    public void navegarParaFormularioEditar(Equipamento equipamentoSelecionado){
        EditarNewEquipamentoFormUI editarNewEquipamentoFormUI = new EditarNewEquipamentoFormUI(this.mainUI, equipamentoSelecionado);
        editarNewEquipamentoFormUI.setVisible(true);
    }
}
