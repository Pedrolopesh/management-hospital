package com.management.UI.Especialidade;

import com.management.Especialidade;
import com.management.UI.PrincipalUI;

import javax.swing.*;
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


        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nextId = generateId();
                String nomeEspecialidade = tfNomeEspecialidade.getText();

                Especialidade especialidade = new Especialidade(nomeEspecialidade, nextId);

                salvarDados(especialidade);
            }
        });
    }


    private int generateId(){
        int nextid = this.mainUI.getEspecialidades().size() + 1;;
        return nextid;
    }

    private void salvarDados(Especialidade novaEspecialidade){
        this.mainUI.getEspecialidades().add(novaEspecialidade);
    }
}
