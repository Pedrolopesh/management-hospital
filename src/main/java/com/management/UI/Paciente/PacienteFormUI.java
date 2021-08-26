package com.management.UI.Paciente;

import com.management.Paciente;
import com.management.UI.PrincipalUI;

import javax.swing.*;
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
    private PrincipalUI mainUI;
    private ArrayList<Paciente> pacientes;


   // Construtor
    public PacienteFormUI(PrincipalUI principalUI){
        this.mainUI = principalUI;
        this.pacientes = new ArrayList<Paciente>();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        btConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nextid = generateId();
                String nome = txNome.getText();
                int idade = Integer.parseInt(txIdade.getText());
                double altura = Double.parseDouble(txAltura.getText());
                double peso = Double.parseDouble(txAltura.getText());
                String comorbidade = txComorbidade.getText();
                String diagnostico = txDiagnostico.getText();
                String necessidade = txNecessidade.getText();
                boolean isolamento = Boolean.parseBoolean(txIsolamento.getText());
                String telefone = txTelefone.getText();

                Paciente exemploPaciente = new Paciente("",1,"",1,1,1.0,"Sim","",false,"", "");
                Paciente novoPaciente = new Paciente(nome, nextid, telefone,idade,altura,peso,comorbidade,diagnostico,isolamento,necessidade, "aguardando");
                salvarPaciente(novoPaciente);
            }
        });
    }

    private int generateId(){
        int nextid = this.mainUI.getPacientes().size() + 1;;
        return nextid;
    }

    private void salvarPaciente(Paciente novoPaciente){ this.mainUI.getPacientes().add(novoPaciente);}

}
