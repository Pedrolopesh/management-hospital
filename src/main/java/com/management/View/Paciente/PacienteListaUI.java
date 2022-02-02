package com.management.View.Paciente;
import com.management.Model.Classes.Paciente;
import com.management.View.PrincipalUI;

import javax.swing.*;

public class PacienteListaUI extends JFrame{
    private JTextArea txTextShow;
    private JPanel mainPanel;
    private PrincipalUI mainUI;

    public PacienteListaUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        for(Paciente umPaciente : this.mainUI.getPacientes()){
            txTextShow.append(umPaciente.imformacaoPacientes());
            txTextShow.append("\n");
        }
    }
}
