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
                Equipamento equipemento = cbEquipamentos.getItemAt(cbEquipamentos.getSelectedIndex());
                String selectEquipemento = equipemento.getNomeEquipamento();

                LeitoHospitalar newLeito = new LeitoHospitalar(false, nextid,selectEquipemento);
                salvarLeito(newLeito);
            }
        });
    }

    private int generateId(){
        int nextid = this.mainUI.getUnidadeHospitalares().size() + 1;
        return nextid;
    }

    private void salvarLeito(LeitoHospitalar newLeito){
        this.mainUI.getLeitos().add(newLeito);
    }
}
