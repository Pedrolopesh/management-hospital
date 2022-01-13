package com.management.View.Equipamento;

import com.management.Controller.Classes.Equipamento;
import com.management.View.PrincipalUI;

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
                int nextid = generateId();
                String NomeEquipamento = txNomeEquipamento.getText();
                int NumeroEquipamentos = Integer.parseInt(txNumeroEquipamentos.getText());

                Equipamento exemploEquipamento = new Equipamento("Respirador",1,nextid);
                Equipamento novoEquipamento = new Equipamento(NomeEquipamento,NumeroEquipamentos,nextid);
                salvarEquipamento(novoEquipamento);
            }
        });
    }
    private int generateId(){
        int nextid = this.mainUI.getFuncionarios().size() + 1;;
        return nextid;
    }
    private void salvarEquipamento(Equipamento novoEquipamento){ this.mainUI.getEquipamentos().add(novoEquipamento);
    }
}
