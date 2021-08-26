package com.management.UI.Paciente;

import com.management.UI.PrincipalUI;

import javax.swing.*;

public class PacienteFormUI extends JFrame{

    private JPanel mainPanel;
    private JTextField txIdade;
    private JTextField txAltura;
    private JTextField txPeso;
    private JTextField txComorbidade;
    private JTextField txDiagnostico;
    private JTextField txNecessidade;
    private JCheckBox cbIsomalento;
    private JButton btConfirmar;
    private PrincipalUI mainUI;

    public PacienteFormUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
