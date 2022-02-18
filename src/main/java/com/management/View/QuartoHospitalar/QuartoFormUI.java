package com.management.View.QuartoHospitalar;

import com.management.Controller.QuartoController;
import com.management.Controller.UnidadeHospitalarController;
import com.management.Model.Classes.Funcionario;
import com.management.Model.Classes.QuartoHospitalar;
import com.management.Model.Classes.UnidadeHospitalar;
import com.management.View.PrincipalUI;
import com.management.utils.Uuid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class QuartoFormUI extends JFrame{
    private JTextField tfNomeQuarto;
    private JLabel labelNumeroLeitos;
    private JTextField tfNumeroLeitos;
    private JButton confirmarButton;
    private JPanel mainPanel;
    private JComboBox cbUnidades;
    private PrincipalUI mainUI;
    private Uuid uuid = new Uuid();
    private UnidadeHospitalarController unidadeHospitalarController = new UnidadeHospitalarController();
    private QuartoController quartoController = new QuartoController();

    public QuartoFormUI(PrincipalUI principalUI) throws SQLException, ClassNotFoundException {
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(300, 400));
        this.setContentPane(mainPanel);
        this.pack();

        for (UnidadeHospitalar umUnidadeHospitalar: this.unidadeHospitalarController.getUnidades()){
            cbUnidades.addItem(umUnidadeHospitalar);
        }

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = tfNomeQuarto.getText();
                int totalLeitos = Integer.parseInt(tfNumeroLeitos.getText());
                UnidadeHospitalar unidadeHospitalar = (UnidadeHospitalar) cbUnidades.getItemAt(cbUnidades.getSelectedIndex());

                QuartoHospitalar newQuartoHospitalar = new QuartoHospitalar(nome, uuid.generateId(), totalLeitos);
                salvarQuarto(newQuartoHospitalar, unidadeHospitalar);
            }
        });
    }

    private void salvarQuarto(QuartoHospitalar newQuartoHospitalar, UnidadeHospitalar unidadeHospitalar){

        try {
            this.quartoController.salvarDadosQuartoWithUnidade(newQuartoHospitalar, unidadeHospitalar.getIdUnidadeHospitalar());
            this.mainUI.getQuartos().add(newQuartoHospitalar);
            JOptionPane.showMessageDialog(this.mainPanel, "Quarto cadastrado com successo!");

        } catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(this.mainPanel, "Erro ao cadastrar quarto!");
        }

    }
}
