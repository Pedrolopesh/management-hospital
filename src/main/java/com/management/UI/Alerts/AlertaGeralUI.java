package com.management.UI.Alerts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlertaGeralUI extends JFrame {
    private JPanel mainPanel;
    private JButton confirmarButton;
    private JLabel mainLabel;


    public AlertaGeralUI(String textoErro) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        mainLabel.setText(textoErro);

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharAlertaGeral();
            }
        });
    }



    public void fecharAlertaGeral(){
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
