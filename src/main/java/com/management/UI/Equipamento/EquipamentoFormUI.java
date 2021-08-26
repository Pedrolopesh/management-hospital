package com.management.UI.Equipamento;

import com.management.Equipamento;
import com.management.Paciente;
import com.management.UI.PrincipalUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EquipamentoFormUI extends JFrame {
    private JPanel mainPanel;
    private JTextField txNomeEquipamento;
    private JTextField txNumeroEquipamentos;
    private JButton btnConfirmar;
    private PrincipalUI mainUI;
    private ArrayList<Equipamento>equipamentos;

    public EquipamentoFormUI (PrincipalUI principalUI){
        this.mainUI = principalUI;
        this.equipamentos = new ArrayList<Equipamento>();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String NomeEquipamento = txNomeEquipamento.getText();
                int NumeroEquipamentos = Integer.parseInt(txNumeroEquipamentos.getText());

                Equipamento exemploEquipamento = new Equipamento("Respirador",1);
                Equipamento novoEquipamento = new Equipamento(NomeEquipamento,NumeroEquipamentos);
                salvarEquipamento(novoEquipamento);
            }
        });
    }
    private void salvarEquipamento(Equipamento novoEquipamento){ this.mainUI.getEquipamentos().add(novoEquipamento);
    }
}
