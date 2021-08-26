package com.management.UI.Pesquisa;

import javax.swing.*;

public class PesquisaUI extends JFrame {
    private JTextArea taResultadoPesquisa;
    private JPanel mainPanel;

    public PesquisaUI(String resultadoPesquisa){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        taResultadoPesquisa.append(resultadoPesquisa);
    }
}
