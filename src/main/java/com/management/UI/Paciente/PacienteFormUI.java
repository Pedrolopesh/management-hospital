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
    private JCheckBox cbIsolamento;
    private JButton btConfirmar;
    private JTextField txNome;
    private JTextField txIsolamento;
    private PrincipalUI mainUI;
    private ArrayList<Paciente> pacientes;

// todo
    // Adicionar evento ao botao btConfirmar
    // Pegar valor dos atributos de tx
    // Criar nova classe paciente dentro de evento do bt
    // Salvar novo paciente

   // Construtor
    public PacienteFormUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        btConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txNome.getText();
                String idade = txIdade.getText();
                String Altura = txAltura.getText();
                String Peso = txPeso.getText();
                String comorbidade = txComorbidade.getText();
                String diagnostico = txDiagnostico.getText();
                String necessidade = txNecessidade.getText();
                String isolamento = txIsolamento.getText();

                Paciente novoPaciente = new Paciente("",1,"","",1,1.0,);
//                Paciente novoPaciente = new Paciente(nome, idade, Altura, Peso, comorbidade, diagnostico, necessidade, isolamento);

            }
        });
    }

    private void salvarPaciente(Paciente novoPaciente){ this.mainUI.getPacientes().add(novoPaciente);}
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
