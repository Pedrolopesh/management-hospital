package com.management.UI.QuartoHospitalar;

import com.management.QuartoHospitalar;
import com.management.UI.PrincipalUI;

import javax.swing.*;

public class QuartoListaUI extends JFrame{
    private JTextArea txTextShow;
    private JPanel mainPanel;
    private PrincipalUI mainUI;

    public QuartoListaUI(PrincipalUI principalUI){
        this.mainUI = principalUI;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        txTextShow.append("--- Todos os Quartos ---");
        txTextShow.append("\n");
        for(QuartoHospitalar umQuarto: this.mainUI.getQuartos()){
            txTextShow.append(umQuarto.toString());
            txTextShow.append("\n");
        }
    }
}
