package com.management.UI.LeitoHospitalar;

import com.management.LeitoHospitalar;
import com.management.Paciente;
import com.management.UI.PrincipalUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LeitoAddPacienteUI extends JFrame{
    private JComboBox<LeitoHospitalar> cbLeitosDisponiveis;
    private JButton confirmarButton;
    private JPanel mainPanel;
    private JComboBox<Paciente> cbPacientes;
    private PrincipalUI mainUI;
    private ArrayList<LeitoHospitalar> leitoHospitalares;

    public LeitoAddPacienteUI(PrincipalUI principalUI){
        this.mainUI = principalUI;
        this.leitoHospitalares = this.mainUI.getLeitos();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        for(LeitoHospitalar umLeito : this.mainUI.getLeitos()){
            if(!umLeito.getOcupado()){
                System.out.println(umLeito);
                cbLeitosDisponiveis.addItem(umLeito);
            }
        }

        for (Paciente umPaciente : this.mainUI.getPacientes()){
            if(umPaciente.getStatusPaciente().equals("aguardando")){
                cbPacientes.addItem(umPaciente);
            }
        }

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeitoHospitalar leitoSelecionado = cbLeitosDisponiveis.getItemAt(cbLeitosDisponiveis.getSelectedIndex());
                Paciente pacienteSelecionado = cbPacientes.getItemAt(cbPacientes.getSelectedIndex());

                confirmarLeitoAddPaciente(leitoSelecionado, pacienteSelecionado);
            }
        });
    }

    private void confirmarLeitoAddPaciente(LeitoHospitalar leitoSelecionado, Paciente pacienteSelecionado){
        for(LeitoHospitalar umleito : this.mainUI.getLeitos()){
            if(umleito.getIdLeito() == leitoSelecionado.getIdLeito()){
                umleito.addPaciente(pacienteSelecionado);

                umleito.setOcupado(true);
                pacienteSelecionado.setStatusPaciente("emLeito");
            }
        }
    }
}
