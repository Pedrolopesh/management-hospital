package com.management.View.Paciente;

import com.management.Controller.PacienteController;
import com.management.Model.Classes.Paciente;
import com.management.Model.Repository.PacienteRepository;
import com.management.View.PrincipalUI;
import com.management.Controller.UserController;
import com.management.Model.Entities.PacienteEntitie;

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

   // Construtor
    public PacienteFormUI(PrincipalUI principalUI){
        this.mainUI = principalUI;
        this.pacientes = new ArrayList<Paciente>();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(300, 600));
        this.setContentPane(mainPanel);
        this.pack();

        btConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nextid = generateId();
                String nome = txNome.getText();
                int idade = Integer.parseInt(txIdade.getText());
                double altura = Double.parseDouble(txAltura.getText());
                double peso = Double.parseDouble(txPeso.getText());
                String comorbidade = txComorbidade.getText();
                String diagnostico = txDiagnostico.getText();
                String necessidade = txNecessidade.getText();
                boolean isolamento = false;
                String telefone = txTelefone.getText();

                if(afirmativeCheckBox.isSelected() && !negativeCheckBox.isSelected()){
                    isolamento = true;
                }else if(negativeCheckBox.isSelected() && !afirmativeCheckBox.isSelected()){
                    isolamento = false;
                }

                Paciente exemploPaciente = new Paciente("",1,"",1,1,1.0,"Sim","",false,"", "");
                Paciente novoPaciente = new Paciente(nome, nextid, telefone,idade,altura,peso,comorbidade,diagnostico,isolamento,necessidade, "aguardando");
                salvarByController(nome, nextid, telefone,idade,altura, peso,comorbidade,diagnostico,isolamento,necessidade, "aguardando");

                System.out.println(nome);
                System.out.println(nextid);
                System.out.println(telefone);
                System.out.println(idade);
                System.out.println(altura);
                System.out.println(peso);
                System.out.println(comorbidade);
                System.out.println(diagnostico);
                System.out.println(isolamento);
                System.out.println(necessidade);
                System.out.println("aguardando");


                salvarPacienteLocalmente(novoPaciente);


//                PacienteEntitie saveTypePaciente = new PacienteEntitie(nome, nextid, telefone,idade,altura,peso,comorbidade,diagnostico,isolamento,necessidade, "aguardando");
//                salvarPacienteDb(saveTypePaciente);
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

    private int generateId(){
        int nextid = this.mainUI.getPacientes().size() + 1;;
        return nextid;
    }

    private void salvarByController(
            String nome, int nextid, String telefone, int idade, double altura, double peso, String comorbidade,
            String diagnostico, boolean isolamento, String necessidade, String statusPaciente)
    {
        PacienteController pacienteController = new PacienteController();
        pacienteController.salvarDadosPaciente(nome, nextid, telefone,idade,altura,peso,comorbidade,diagnostico,isolamento,necessidade, statusPaciente);
    }

    private void salvarPacienteLocalmente(Paciente novoPaciente){
        UserController userController = new UserController();
//        userController.registrarPaciente(novoPaciente);

        this.mainUI.getPacientes().add(novoPaciente);
    }

    private void salvarPacienteDb(PacienteEntitie novoPacienteParam){
        try {
            UserController userController = new UserController();
            userController.registrarPaciente(novoPacienteParam);
        } catch (Exception e){
            System.out.println(e);
        }
    }

}
