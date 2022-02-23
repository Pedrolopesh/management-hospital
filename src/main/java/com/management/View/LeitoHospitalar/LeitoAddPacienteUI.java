package com.management.View.LeitoHospitalar;

import com.management.Controller.FuncionarioController;
import com.management.Controller.LeitoController;
import com.management.Controller.PacienteController;
import com.management.Model.Classes.Funcionario;
import com.management.Model.Classes.LeitoHospitalar;
import com.management.Model.Classes.Paciente;
import com.management.View.PrincipalUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class LeitoAddPacienteUI extends JFrame{
    private LeitoFormUI leitoFormUI;
    private JComboBox<LeitoHospitalar> cbLeitosDisponiveis;
    private JButton confirmarButton;
    private JPanel mainPanel;
    private JComboBox<Paciente> cbPacientes;
    private JComboBox<Funcionario> cbFuncionarios;
    private PrincipalUI mainUI;
    private ArrayList<LeitoHospitalar> leitoHospitalares;
    private PacienteController pacienteController = new PacienteController();
    private LeitoController leitoController = new LeitoController(this.leitoFormUI);
    private FuncionarioController funcionarioController = new FuncionarioController();


    public LeitoAddPacienteUI(PrincipalUI principalUI) throws SQLException, ClassNotFoundException {
        this.mainUI = principalUI;
        this.leitoHospitalares = this.mainUI.getLeitos();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(400, 300));
        this.setContentPane(mainPanel);
        this.pack();

        for(LeitoHospitalar umLeito : this.leitoController.getLeitos()){
            if(!umLeito.getOcupado()){
                cbLeitosDisponiveis.addItem(umLeito);
            }
        }

        for (Paciente umPaciente : this.pacienteController.getPacientes()){
            if(umPaciente.getStatusPaciente().equals("aguardando")){
                cbPacientes.addItem(umPaciente);
            }
        }

        for (Funcionario umFuncionario : this.funcionarioController.getFuncionarios()){
            cbFuncionarios.addItem(umFuncionario);
        }

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeitoHospitalar leitoSelecionado = cbLeitosDisponiveis.getItemAt(cbLeitosDisponiveis.getSelectedIndex());
                Paciente pacienteSelecionado = cbPacientes.getItemAt(cbPacientes.getSelectedIndex());
                Funcionario funcionarioSelecionado = cbFuncionarios.getItemAt(cbFuncionarios.getSelectedIndex());

                confirmarLeitoAddPaciente(leitoSelecionado, pacienteSelecionado, funcionarioSelecionado);
            }
        });
    }

    private void confirmarLeitoAddPaciente(LeitoHospitalar leitoSelecionado, Paciente pacienteSelecionado, Funcionario funcionarioSelecionado){

        try {
            this.pacienteController.internarPacienteLeito(leitoSelecionado, pacienteSelecionado, funcionarioSelecionado);
            this.mainUI.calcPacientesInternados();
            this.mainUI.calcPacientesAguardando();
            JOptionPane.showMessageDialog(this.mainPanel, "Paciente alocado em leito!");

        } catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(this.mainPanel, "erro ao alocar paciente!");

        }

//        funcionarioSelecionado.atendimento(pacienteSelecionado.getNome());
//        pacienteSelecionado.atendimento(funcionarioSelecionado.getNome());
//
//        for(LeitoHospitalar umleito : this.mainUI.getLeitos()){
//            if(umleito.getIdLeito() == leitoSelecionado.getIdLeito()){
//                umleito.setPaciente(pacienteSelecionado);
//
//                umleito.setOcupado(true);
//                pacienteSelecionado.setStatusPaciente("emLeito");
//            }
//        }
    }
}
