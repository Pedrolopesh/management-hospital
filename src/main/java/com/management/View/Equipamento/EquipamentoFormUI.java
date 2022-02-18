package com.management.View.Equipamento;

import com.management.Controller.EquipamentoController;
import com.management.Model.Classes.Equipamento;
import com.management.View.PrincipalUI;
import com.management.utils.Uuid;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;

public class EquipamentoFormUI extends JFrame {
    private JPanel mainPanel;
    private JTextField txNomeEquipamento;
    private JTextField txNumeroEquipamentos;
    private JButton btnConfirmar;
    private PrincipalUI mainUI;
    private ArrayList<Equipamento>equipamentos;
    private Uuid uuid = new Uuid();
    private EquipamentoController equipamentoController = new EquipamentoController();

    public EquipamentoFormUI (PrincipalUI principalUI){
        this.mainUI = principalUI;
        this.equipamentos = new ArrayList<Equipamento>();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(300, 300));
        this.setContentPane(mainPanel);
        this.pack();

        btnConfirmar.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                String NomeEquipamento = txNomeEquipamento.getText();
                int NumeroEquipamentos = Integer.parseInt(txNumeroEquipamentos.getText());

                Equipamento novoEquipamento = new Equipamento(NomeEquipamento,NumeroEquipamentos, uuid.generateId());
                salvarEquipamento(novoEquipamento);
            }
        });
    }

    private void salvarEquipamento(Equipamento novoEquipamento) {
        try {
            this.equipamentoController.salvarDadosEquipamento(novoEquipamento);
            JOptionPane.showMessageDialog(this.mainPanel, "Equipamento cadastrado com successo!");

        } catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(this.mainPanel, "Erro ao criar equipamento!");
        }
    }
}
