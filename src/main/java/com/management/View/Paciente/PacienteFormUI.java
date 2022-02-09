package com.management.View.Paciente;

import com.management.Controller.PacienteController;
import com.management.Model.Classes.Paciente;
import com.management.Model.Repository.PacienteRepository;
import com.management.View.PrincipalUI;
import com.management.Controller.UserController;
import com.management.Model.Entities.PacienteEntitie;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

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
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                String nextid = generateId();
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
                salvarByController(nome, nextid, telefone,idade,altura, peso,comorbidade,diagnostico,isolamento, necessidade, "aguardando", "Não possui");

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

    private String generateId(){
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        return uuidAsString;
    }

    private void salvarByController(
            String nomeParam, String nextidParam, String telefoneParam, int idadeParam, double alturaParam, double pesoParam, String comorbidadeParam,
            String diagnosticoParam, String isolamentoParam, String necessidadeParam, String statusPacienteParam, String funcionarioAntedimentoParam) throws ClassNotFoundException, SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

            String nextid = nextidParam;
            String nome = nomeParam;
            String telefone = telefoneParam;
            double idade = idadeParam;
            double altura = alturaParam;
            double peso = pesoParam;
            String diagnostico = diagnosticoParam;
            String isolamento = isolamentoParam;
            String necessidade = necessidadeParam;
            String statusPaciente = statusPacienteParam;
            String comorbidade = comorbidadeParam;
            String funcionarioAntedimento = funcionarioAntedimentoParam;

            PreparedStatement ps = conn.prepareStatement(
                    "insert into paciente " +
                            "(id, nome, telefone, idade, altura, peso, diagnostico, isolamento, necessidade, statusPaciente, comorbidade, funcionarioAntedimento) " +
                            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, nextid);
            ps.setString(2, nome);
            ps.setString(3, telefone);
            ps.setDouble(4, idade);
            ps.setDouble(5, altura);
            ps.setDouble(6, peso);
            ps.setString(7, diagnostico);
            ps.setString(8, isolamento);
            ps.setString(9, necessidade);
            ps.setString(10, statusPaciente);
            ps.setString(11, comorbidade);
            ps.setString(12, funcionarioAntedimento);


            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Insert Sucessfully");
        }catch (SQLException e) {
            System.out.println(e);
        }
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
