package com.management.View.UnidadeHospitalar;

import com.management.Controller.EspecialidadeController;
import com.management.Controller.UnidadeHospitalarController;
import com.management.Model.Classes.Especialidade;
import com.management.View.PrincipalUI;
import com.management.Model.Classes.UnidadeHospitalar;
import com.management.utils.Uuid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UnidadeFormularioUI extends JFrame {
    private JPanel mainPanel;
    private JLabel labelUnidade;
    private JTextField tfNomeUnidade;
    private JLabel labelEspecialidade;
    private JComboBox<Especialidade> cbEspecialidades;
    private JButton salvarButton;
    private PrincipalUI mainUI;
    private Uuid uuid = new Uuid();
    private UnidadeHospitalarController unidadeHospitalarController = new UnidadeHospitalarController();
    private EspecialidadeController especialidadeController = new EspecialidadeController();

    public UnidadeFormularioUI(PrincipalUI principalUI) throws SQLException, ClassNotFoundException {
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(300, 300));
        this.setContentPane(mainPanel);
        this.pack();

        for(Especialidade umaEspecialidade: this.especialidadeController.getEspecialidades()){
            cbEspecialidades.addItem(umaEspecialidade);
        }

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeUnidade = tfNomeUnidade.getText();

                Especialidade selectEquipe = cbEspecialidades.getItemAt(cbEspecialidades.getSelectedIndex());

                String especialidade = selectEquipe.getNomeEspecialidade();

                UnidadeHospitalar newUnidadeHospitalar = new UnidadeHospitalar(nomeUnidade, uuid.generateId());
                salvarUnidade(newUnidadeHospitalar, especialidade);
            }
        });

    }

    private void salvarUnidade(UnidadeHospitalar newUnidadeHospitalar, String selectEquipe){
        try {
            this.unidadeHospitalarController.salvarDadosUnidade(newUnidadeHospitalar);
            this.mainUI.getUnidadeHospitalares().add(newUnidadeHospitalar);
            JOptionPane.showMessageDialog(this.mainPanel, "Unidade cadastrada com successo!");

        }catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(this.mainPanel, "Unidade cadastrada com successo!");

        }
    }
}
