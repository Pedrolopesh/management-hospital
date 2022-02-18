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
    private JComboBox<Equipamento> cbEquipamentos;
    private JButton salvarButton;
    private JPanel mainPanel;
    private JComboBox cbQuartos;
    private PrincipalUI mainUI;
    private QuartoController quartoController = new QuartoController();
    private Uuid uuid = new Uuid();
    private LeitoController leitoController = new LeitoController();
    private EquipamentoController equipamentoController = new EquipamentoController();

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


        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Equipamento equipamentoSelecionado = cbEquipamentos.getItemAt(cbEquipamentos.getSelectedIndex());
//                UnidadeHospitalar unidadeHospitalar = (UnidadeHospitalar) cbUnidades.getItemAt(cbUnidades.getSelectedIndex());
                QuartoHospitalar quartoHospitalar = (QuartoHospitalar) cbQuartos.getItemAt(cbQuartos.getSelectedIndex());

                LeitoHospitalar newLeito = new LeitoHospitalar(uuid.generateId(), false);

                salvarLeito(newLeito,equipamentoSelecionado, quartoHospitalar);
            }
        });
    }

    private void salvarLeito(LeitoHospitalar newLeito,Equipamento equipamentoSelecionado, QuartoHospitalar selectedQuarto ){
        this.mainUI.getLeitos().add(newLeito);

        this.leitoController.salvarDadosLeitoWithQuarto(newLeito, selectedQuarto.getIdQuarto());

//        for (Equipamento umEquipamento : this.mainUI.getEquipamentos()){
//            if(umEquipamento.getIdEquipamento() == equipamentoSelecionado.getIdEquipamento()){
//                newLeito.addEquipamento(equipamentoSelecionado);
//            }
//        }
    }

}
