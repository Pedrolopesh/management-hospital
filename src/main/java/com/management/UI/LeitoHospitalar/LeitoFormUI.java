package com.management.UI.LeitoHospitalar;

import com.management.Equipamento;
import com.management.LeitoHospitalar;
import com.management.UI.PrincipalUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeitoFormUI extends JFrame {
    private JLabel labelEquipamentos;
    private JComboBox<Equipamento> cbEquipamentos;
    private JButton salvarButton;
    private JPanel mainPanel;
    private PrincipalUI mainUI;

    public LeitoFormUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        for (Equipamento umEquipamento: this.mainUI.getEquipamentos()){
            cbEquipamentos.addItem(umEquipamento);
        }

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nextid = generateId();
                Equipamento equipamentoSelecionado = cbEquipamentos.getItemAt(cbEquipamentos.getSelectedIndex());

                LeitoHospitalar newLeito = new LeitoHospitalar(nextid);
                newLeito.setOcupado(false);
                salvarLeito(newLeito,equipamentoSelecionado);
            }
        });
    }

    private int generateId(){
        int nextid = this.mainUI.getUnidadeHospitalares().size() + 1;
        return nextid;
    }

    private void salvarLeito(LeitoHospitalar newLeito,Equipamento equipamentoSelecionado){
        this.mainUI.getLeitos().add(newLeito);
        for (Equipamento umEquipamento : this.mainUI.getEquipamentos()){
            if(umEquipamento.getIdEquipamento() == equipamentoSelecionado.getIdEquipamento()){
                newLeito.addEquipamento(equipamentoSelecionado);
            }
        }
    }
}
