package com.management.UI.UnidadeHospitalar;

import com.management.Equipe;
import com.management.Especialidade;
import com.management.UI.PrincipalUI;
import com.management.UnidadeHospitalar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnidadeFormUI extends JFrame {
    private JLabel labelEspecialidade;
    private JLabel labelNomeUnidade;
    private JTextField tfNomeUnidade;
    private JComboBox<Especialidade> cbEspecialidades;
    private JButton salvarButton;
    private JPanel mainPanel;
    private PrincipalUI mainUI;

    public UnidadeFormUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        for(Especialidade umaEspecialidade: this.mainUI.getEspecialidades()){
            cbEspecialidades.addItem(umaEspecialidade);
        }

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nextid = generateId();
                String nomeUnidade = tfNomeUnidade.getText();
                Especialidade selectEquipe = cbEspecialidades.getItemAt(cbEspecialidades.getSelectedIndex());
                System.out.println("selectEquipe: " + selectEquipe.getNomeEspecialidade());
                String especialidade = selectEquipe.getNomeEspecialidade();

                UnidadeHospitalar newUnidadeHospitalar = new UnidadeHospitalar(nomeUnidade, nextid);
                salvarUnidade(newUnidadeHospitalar, especialidade);
            }
        });
    }
    private int generateId(){
        int nextid = this.mainUI.getUnidadeHospitalares().size() + 1;
        return nextid;
    }

    private void salvarUnidade(UnidadeHospitalar newUnidadeHospitalar, String selectEquipe){
        newUnidadeHospitalar.setEspecialidade(selectEquipe);
        this.mainUI.getUnidadeHospitalares().add(newUnidadeHospitalar);
    }

}
