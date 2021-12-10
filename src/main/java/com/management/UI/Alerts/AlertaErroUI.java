package com.management.UI.Alerts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlertaErroUI extends JFrame {
    private JPanel mainPanel;
    private JButton confirmarButton;

    public AlertaErroUI(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharAlerta();
            }
        });
    }

    public void fecharAlerta(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
