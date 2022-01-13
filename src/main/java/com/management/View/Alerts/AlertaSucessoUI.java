package com.management.View.Alerts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlertaSucessoUI extends JFrame {
    private JButton confirmarButton;
    private JPanel mainPanel;

    public AlertaSucessoUI() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharAlertaSucesso();
            }
        });
    }

    public void fecharAlertaSucesso(){
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
