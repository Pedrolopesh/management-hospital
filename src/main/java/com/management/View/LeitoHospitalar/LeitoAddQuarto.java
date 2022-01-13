package com.management.View.LeitoHospitalar;

import com.management.Controller.Classes.LeitoHospitalar;
import com.management.Controller.Classes.QuartoHospitalar;
import com.management.View.PrincipalUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeitoAddQuarto extends JFrame {
    private JComboBox<QuartoHospitalar> cbQuarto;
    private JComboBox<LeitoHospitalar> cbLeito;
    private JButton confirmarButton;
    private JPanel mainPanel;
    private PrincipalUI mainUI;

    public LeitoAddQuarto(PrincipalUI principalUI) {
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        for (QuartoHospitalar umQuarto: this.mainUI.getQuartos()){
            cbQuarto.addItem(umQuarto);
        }

        for (LeitoHospitalar umLeito: this.mainUI.getLeitos()){
            cbLeito.addItem(umLeito);
        }

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                QuartoHospitalar quartoSelecionado = cbQuarto.getItemAt(cbQuarto.getSelectedIndex());
                LeitoHospitalar leitoSelecionado = cbLeito.getItemAt(cbLeito.getSelectedIndex());

                confirmarSalvarPaciente(quartoSelecionado, leitoSelecionado);
            }
        });
    }

    public void confirmarSalvarPaciente(QuartoHospitalar quartoSelecionado, LeitoHospitalar leitoSelecionado){
        for (QuartoHospitalar quartoHospitalar : this.mainUI.getQuartos()){
            if(quartoHospitalar.getIdQuarto() == quartoSelecionado.getIdQuarto()){
                quartoHospitalar.addLeitoHospitalar(leitoSelecionado);
            }
        }
    }
}
