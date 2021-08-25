package com.management.UI.UnidadeHospitalar;

import com.management.Equipe;
import com.management.UI.PrincipalUI;
import com.management.UnidadeHospitalar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnidadeFormUI extends JFrame {
    private JLabel labelEspecialidade;
    private JLabel labelNomeUnidade;
    private JTextField tfNomeUnidade;
    private JComboBox<Equipe> cbEspecialidades;
    private JButton salvarButton;
    private JPanel mainPanel;
    private PrincipalUI mainUI;

    public UnidadeFormUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        for(Equipe umaEquipe: this.mainUI.getEquipes()){
            cbEspecialidades.addItem(umaEquipe);
        }

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nextid = generateId();
                String nomeUnidade = tfNomeUnidade.getText();
                Equipe selectEquipe = cbEspecialidades.getItemAt(cbEspecialidades.getSelectedIndex());

                UnidadeHospitalar newUnidadeHospitalar = new UnidadeHospitalar(nomeUnidade, nextid, selectEquipe.getNomeEquipe());
                salvarEquipe(newUnidadeHospitalar);
            }
        });
    }

    private void salvarEquipe(UnidadeHospitalar newUnidadeHospitalar){
        this.mainUI.getUnidadeHospitalares().add(newUnidadeHospitalar);
    }

    private int generateId(){
        int nextid = this.mainUI.getUnidadeHospitalares().size() + 1;
        return nextid;
    }
}
