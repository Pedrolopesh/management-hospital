package com.management.UI.Paciente;
import com.management.Paciente;
import com.management.UI.PrincipalUI;

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
            //append = atribui item
            txTextShow.append(umPaciente.imformacaoPacientes());
            txTextShow.append("\n");
        }
    }
}
