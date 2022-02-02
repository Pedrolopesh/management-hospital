package com.management.View.LeitoHospitalar;
import java.util.Collections;

import com.management.Model.Classes.LeitoHospitalar;
import com.management.View.PrincipalUI;

import javax.swing.*;

public class LeitoListaUI extends JFrame {
    private JPanel mainPanel;
    private JTextArea txShowList;
    private PrincipalUI mainUI;

    public LeitoListaUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);


        txShowList.append("--- Todos os Leitos --- \n");
        Collections.sort(this.mainUI.getLeitos());
        for (LeitoHospitalar umLeito: this.mainUI.getLeitos()){
            txShowList.append("\n --- Informações do Leito --- \n");
            txShowList.append(umLeito.imformacao());
        }

    }
}
