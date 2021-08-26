package com.management.UI.LeitoHospitalar;

import com.management.LeitoHospitalar;
import com.management.UI.PrincipalUI;

import javax.swing.*;

public class LeitoListaUI extends JFrame {
    private JPanel mainPanel;
    private JTextArea txShowList;
    private PrincipalUI mainUI;

    public LeitoListaUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);


        txShowList.append("--- Todos os Leitos ---");
        txShowList.append("\n");
        for (LeitoHospitalar umLeito: this.mainUI.getLeitos()){
            txShowList.append("--- Informações do Leito --- \n");
            txShowList.append(umLeito.toString());
            txShowList.append("\n");
            txShowList.append("--- Equipamentos do Leito --- \n");
            txShowList.append(umLeito.imprimeEquipamento());
        }

    }
}
