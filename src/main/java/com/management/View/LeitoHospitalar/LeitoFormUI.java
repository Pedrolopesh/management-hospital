package com.management.View.LeitoHospitalar;

import com.management.Controller.EquipamentoController;
import com.management.Controller.LeitoController;
import com.management.Controller.QuartoController;
import com.management.Model.Classes.Equipamento;
import com.management.Model.Classes.LeitoHospitalar;
import com.management.Model.Classes.QuartoHospitalar;
import com.management.Model.Classes.UnidadeHospitalar;
import com.management.View.PrincipalUI;
import com.management.utils.Uuid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LeitoFormUI extends JFrame {
    private JLabel labelEquipamentos;
    private LeitoFormUI leitoFormUI;
    private JComboBox<Equipamento> cbEquipamentos;
    private JButton salvarButton;
    private JPanel mainPanel;
    private JComboBox cbQuartos;
    private JTextField tfNomeLeito;
    private PrincipalUI mainUI;
    private QuartoController quartoController = new QuartoController();
    private Uuid uuid = new Uuid();
    private LeitoController leitoController = new LeitoController(this.leitoFormUI);
    private EquipamentoController equipamentoController = new EquipamentoController();
    private LeitoHospitalar newLeito;

    public LeitoFormUI(PrincipalUI principalUI) throws SQLException, ClassNotFoundException {
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(500, 250));
        this.setContentPane(mainPanel);
        this.pack();

        for (Equipamento umEquipamento: this.equipamentoController.getEquipamentos()){
            cbEquipamentos.addItem(umEquipamento);
        }

        for (QuartoHospitalar umQuartoHospitalar: this.quartoController.getQuartos()){
            cbQuartos.addItem(umQuartoHospitalar);
        }

        Equipamento equipamentoSelecionado = cbEquipamentos.getItemAt(cbEquipamentos.getSelectedIndex());
        QuartoHospitalar quartoHospitalar = (QuartoHospitalar) cbQuartos.getItemAt(cbQuartos.getSelectedIndex());
        String nomeLeito = tfNomeLeito.getText();
        LeitoHospitalar newLeito = new LeitoHospitalar(nomeLeito, uuid.generateId(), false);
        this.newLeito = newLeito;

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipamento equipamentoSelecionado = cbEquipamentos.getItemAt(cbEquipamentos.getSelectedIndex());
                QuartoHospitalar quartoHospitalar = (QuartoHospitalar) cbQuartos.getItemAt(cbQuartos.getSelectedIndex());
                String nomeLeito = tfNomeLeito.getText();
                LeitoHospitalar newLeito = new LeitoHospitalar(nomeLeito, uuid.generateId(), false);

                salvarLeito(newLeito,equipamentoSelecionado, quartoHospitalar);
            }
        });
    }

    public void showAlert(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }

    public LeitoHospitalar dadosNovoLeito(){
        return this.newLeito;
    }

    private void salvarLeito(LeitoHospitalar newLeito,Equipamento equipamentoSelecionado, QuartoHospitalar selectedQuarto ){
        System.out.println(newLeito.getNomeLeito());
        System.out.println(newLeito.getIdLeito());
        System.out.println(newLeito.getOcupado());

        try {
            this.leitoController.salvarDadosLeitoWithQuartoEquipamento(newLeito, equipamentoSelecionado, selectedQuarto.getIdQuarto());
            JOptionPane.showMessageDialog(this.mainPanel, "Leito cadastrado com successo!");

        }catch (Exception e) {
            JOptionPane.showMessageDialog(this.mainPanel, "Erro ao cadastrar leito!");
            System.out.println(e);
        }
    }

}
