package com.management.UI;

import javax.swing.*;

public class FuncionarioListaUI extends JFrame{
    private JPanel mainPanel;
    private JTable table1;


    public FuncionarioListaUI(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    public static void main(String[] args){
        JFrame frame = new FuncionarioListaUI();
        frame.setVisible(true);
    }
}
