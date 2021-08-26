package com.management.UI.Equipamento;

import javax.swing.*;

import com.management.Equipamento;
import com.management.Especialidade;
import com.management.UI.PrincipalUI;

import java.security.Principal;

public class EquipamentoListaUI extends JFrame  {
    private JPanel mainPainel;
    private JTextArea txTextShow;
    private PrincipalUI mainUI;
    // Contrutor
    public EquipamentoListaUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPainel);

        // Todo, entrou .getEquipamentos porem to em duvida se é Equipamento.
        for(Equipamento umEquipamento : this.mainUI.getEquipamentos()){
            //append = atribui item
            txTextShow.append(umEquipamento.toString());
            txTextShow.append("\n");
        }
    }
}
