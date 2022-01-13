package com.management.View.Especialidade;

import com.management.Controller.Classes.Especialidade;
import com.management.View.Alerts.AlertaGeralUI;
import com.management.View.PrincipalUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EspecialidadeFormUi extends JFrame {
    private JPanel mainPanel;
    private JTextField tfNomeEspecialidade;
    private JButton confirmarButton;
    private PrincipalUI mainUI;


    public EspecialidadeFormUi(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        mainPanel.setPreferredSize(new Dimension(300, 300));
        this.pack();

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nextId = generateId();
                String nomeEspecialidade = tfNomeEspecialidade.getText();

                try {
                    checkInputs(nomeEspecialidade, nextId);
                    Especialidade especialidade = new Especialidade(nomeEspecialidade, nextId);
                    salvarDados(especialidade);

                }catch (Exception ex){
                    String log = ex.getMessage();
                    System.out.println(log);
                }
            }
        });
    }

    private void checkInputs(String texto, int id){
        System.out.println(texto.isEmpty());
        System.out.println(id == 0);

        if(texto.isEmpty() || id == 0){
            AlertaGeralUI alertaGeralUI = new AlertaGeralUI("Erro ao cadastrar Especialidade, verifique os campos!"); //ALERTA PARA CONSOLE
            alertaGeralUI.setVisible(true);
            throw new NullPointerException();
        }
    }

    private int generateId(){
        int nextid = this.mainUI.getEspecialidades().size() + 1;;
        return nextid;
    }

    private void salvarDados(Especialidade novaEspecialidade){
        this.mainUI.getEspecialidades().add(novaEspecialidade);
    }
}
