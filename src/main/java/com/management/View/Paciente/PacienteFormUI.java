package com.management.View.Paciente;

import com.management.Controller.PacienteController;
import com.management.Model.Classes.Paciente;
import com.management.Model.Repository.PacienteRepository;
import com.management.View.PrincipalUI;
import com.management.Model.Entities.PacienteEntitie;
import com.management.utils.Uuid;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PacienteFormUI extends JFrame{

    private JPanel mainPanel;
    private JTextField txIdade;
    private JTextField txAltura;
    private JTextField txPeso;
    private JTextField txComorbidade;
    private JTextField txDiagnostico;
    private JTextField txNecessidade;
    private JButton btConfirmar;
    private JTextField txNome;
    private JTextField txIsolamento;
    private JTextField txTelefone;
    private JCheckBox afirmativeCheckBox;
    private JCheckBox negativeCheckBox;
    private PrincipalUI mainUI;
    private ArrayList<Paciente> pacientes;
    private PacienteEntitie pacienteEntitie;
    private PacienteRepository pacienteRepository;
    private PacienteController pacienteController = new PacienteController();
    private Uuid uuid = new Uuid();

   // Construtor
    public PacienteFormUI(PrincipalUI principalUI){
        this.mainUI = principalUI;
        this.pacientes = new ArrayList<Paciente>();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(300, 600));
        this.setContentPane(mainPanel);
        this.pack();

        btConfirmar.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                String nextid = uuid.generateId();
                String nome = txNome.getText();
                int idade = Integer.parseInt(txIdade.getText());
                double altura = Double.parseDouble(txAltura.getText());
                double peso = Double.parseDouble(txPeso.getText());
                String comorbidade = txComorbidade.getText();
                String diagnostico = txDiagnostico.getText();
                String necessidade = txNecessidade.getText();
                String isolamento = "não";
                String telefone = txTelefone.getText();

                if(afirmativeCheckBox.isSelected() && !negativeCheckBox.isSelected()){
                    isolamento = "sim";
                }else if(negativeCheckBox.isSelected() && !afirmativeCheckBox.isSelected()){
                    isolamento = "não";
                }

                Paciente exemploPaciente = new Paciente("","1","",1,1,1.0,"Sim","","false","", "");
                Paciente novoPaciente = new Paciente(nome, nextid, telefone,idade,altura,peso,comorbidade,diagnostico,isolamento,necessidade, "aguardando");
                salvarPaciente(novoPaciente);

            }
        });

        afirmativeCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                negativeCheckBox.setSelected(false);
            }
        });
        negativeCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afirmativeCheckBox.setSelected(false);
            }
        });
    }

    private void salvarPaciente(Paciente novoPaciente){

        try {
            this.pacienteController.salvarDadosPaciente(novoPaciente);
            JOptionPane.showMessageDialog(this.mainPanel, "Paciente cadastrado com successo!");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this.mainPanel, "Erro ao cadastrar Paciente!");
        }

    }
}
