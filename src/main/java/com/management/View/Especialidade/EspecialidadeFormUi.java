package com.management.View.Especialidade;

import com.management.Controller.EspecialidadeController;
import com.management.Model.Classes.Especialidade;
import com.management.View.Alerts.AlertaGeralUI;
import com.management.View.PrincipalUI;
import com.management.utils.Uuid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EspecialidadeFormUi extends JFrame {
    private JPanel mainPanel;
    private JTextField tfNomeEspecialidade;
    private JButton confirmarButton;
    private PrincipalUI mainUI;
    private Uuid uuidLocal = new Uuid();
    private EspecialidadeController especialidadeController = new EspecialidadeController();

    public EspecialidadeFormUi(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        mainPanel.setPreferredSize(new Dimension(300, 300));
        this.setContentPane(mainPanel);
        this.pack();

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeEspecialidade = tfNomeEspecialidade.getText();

                try {
                    Especialidade especialidade = new Especialidade(nomeEspecialidade, uuidLocal.generateId() );
                    salvarDados(especialidade);

                }catch (Exception ex){
                    String log = ex.getMessage();
                    System.out.println(log);
                }
            }
        });
    }

    private void salvarDados(Especialidade novaEspecialidade){
        try {
            this.especialidadeController.salvarDadosEspecialidade(novaEspecialidade);
            this.mainUI.getEspecialidades().add(novaEspecialidade);
            JOptionPane.showMessageDialog(this.mainPanel, "Especialidade cadastrado com successo!");

        }catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(this.mainPanel, "Erro ao cadastrar especialidade!");
        }
    }
}
