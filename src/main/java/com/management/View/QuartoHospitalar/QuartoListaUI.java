package com.management.View.QuartoHospitalar;

import com.management.Model.Classes.QuartoHospitalar;
import com.management.View.PrincipalUI;

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
            txTextShow.append(umQuarto.informaLeitos());
            txTextShow.append("\n");
        }
    }
}
