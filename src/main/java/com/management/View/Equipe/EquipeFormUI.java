package com.management.View.Equipe;

import com.management.Controller.EquipeController;
import com.management.Controller.FuncionarioController;
import com.management.Controller.UnidadeHospitalarController;
import com.management.Model.Classes.Equipe;
import com.management.Model.Classes.Funcionario;
import com.management.Model.Classes.UnidadeHospitalar;
import com.management.View.PrincipalUI;
import com.management.utils.Uuid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class EquipeFormUI extends JFrame {
    private JPanel mainPanel;
    private JLabel labelNome;
    private JButton botaoSalvar;
    private JTextField tfNomeEquipe;
    private JComboBox<Funcionario> cbFuncionarios;
    private JLabel labelLiderEquipe;
    private JComboBox cbUnidades;
    private PrincipalUI mainUI;
    private Uuid uuidLocal = new Uuid();
    private EquipeController equipeController = new EquipeController();
    private FuncionarioController funcionarioController = new FuncionarioController();
    private UnidadeHospitalarController unidadeHospitalarController = new UnidadeHospitalarController();

    public EquipeFormUI(PrincipalUI principalUI) throws SQLException, ClassNotFoundException {
        this.mainUI = principalUI;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(300, 300));
        this.setContentPane(mainPanel);
        this.pack();

        for (Funcionario umFuncionario: this.funcionarioController.getFuncionarios()){
            cbFuncionarios.addItem(umFuncionario);
        }

        for (UnidadeHospitalar umUnidadeHospitalar: this.unidadeHospitalarController.getUnidades()){
            cbUnidades.addItem(umUnidadeHospitalar);
        }

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nextid = uuidLocal.generateId();
                String nome = tfNomeEquipe.getText();
                Funcionario liderEquipe = cbFuncionarios.getItemAt(cbFuncionarios.getSelectedIndex());

                Equipe novaEquipe = new Equipe(nome, nextid, "ativa", "");
                novaEquipe.setLiderEquipe(liderEquipe.getNome());

                salvarEquipe(novaEquipe);
            }
        });
    }

    private void salvarEquipe(Equipe newEquipe){
        try {
            this.equipeController.salvarDadosEquipe(newEquipe);
            this.mainUI.getEquipes().add(newEquipe);
            JOptionPane.showMessageDialog(this.mainPanel, "equipe cadastrada com successo!");
        }catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(this.mainPanel, "Erro ao adicionar equipe!");

        }
    }
}
