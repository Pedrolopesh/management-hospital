package com.management.UI.UnidadeHospitalar;

import com.management.Especialidade;
import com.management.UI.PrincipalUI;
import com.management.UnidadeHospitalar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnidadeFormularioUI extends JFrame {
    private JPanel mainPanel;
    private JLabel labelUnidade;
    private JTextField tfNomeUnidade;
    private JLabel labelEspecialidade;
    private JComboBox<Especialidade> cbEspecialidades;
    private JButton salvarButton;
    private PrincipalUI mainUI;

    public UnidadeFormularioUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        for(Especialidade umaEspecialidade: this.mainUI.getEspecialidades()){
            cbEspecialidades.addItem(umaEspecialidade);
        }

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nextid = generateId();
                String nomeUnidade = tfNomeUnidade.getText();

                Especialidade selectEquipe = cbEspecialidades.getItemAt(cbEspecialidades.getSelectedIndex());

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
