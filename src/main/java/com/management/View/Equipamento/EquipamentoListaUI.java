package com.management.View.Equipamento;

import javax.swing.*;

import com.management.Controller.Classes.Equipamento;
import com.management.View.PrincipalUI;

public class EquipamentoListaUI extends JFrame  {
    private JPanel mainPainel;
    private JTextArea txTextShow;
    private PrincipalUI mainUI;
    // Contrutor
    public EquipamentoListaUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPainel);

        for(Equipamento umEquipamento : this.mainUI.getEquipamentos()){
            //append = atribui item



            txTextShow.append(umEquipamento.toString());
            txTextShow.append("\n");
        }
    }
}
