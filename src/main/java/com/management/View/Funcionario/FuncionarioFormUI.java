package com.management.View.Funcionario;

import com.management.Controller.Classes.Excessao;
import com.management.Controller.Classes.Funcionario;
import com.management.View.Alerts.AlertaGeralUI;
import com.management.View.Alerts.AlertaSucessoUI;
import com.management.View.PrincipalUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FuncionarioFormUI extends JFrame {
    private JPanel mainPanel;
    private JLabel cargoFuncionario;
    private JLabel lbNomeFuncionario;
    private JLabel lbTelefoneFuncionario;

    private JTextField tfNomeFuncionario;
    private JTextField tftelefoneFuncionario;
    private JTextField tfCargoFuncionario;
    private JButton confirmarButton;
    private PrincipalUI mainUI;
    private ArrayList<Funcionario> funcionarios;
    private Excessao excessao;

// Construtor
    public FuncionarioFormUI(PrincipalUI principalUIParam){
        this.mainUI = principalUIParam;
        this.funcionarios = new ArrayList<Funcionario>();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(300, 300));
//        mainPanel.repaint();
        this.setContentPane(mainPanel);
        this.pack();

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nextid = generateId();
                String nome = tfNomeFuncionario.getText();
                String telefone = tftelefoneFuncionario.getText();
                String cargo = tfCargoFuncionario.getText();

                Funcionario newFuncionario = new Funcionario(nome, nextid, telefone);

                try {
                    checkInputEntries(nome, nextid, telefone, cargo);
                    newFuncionario.setCargo(cargo);
                    salvaFuncionario(newFuncionario);
                } catch (Excessao ex) {
                    String log = ex.getMessage();
                    System.out.println(log);
                }

            }
        });
    }

    private int generateId(){
        int nextid = this.mainUI.getFuncionarios().size() + 1;
        return nextid;
    }

    private void checkInputEntries(String nome, int id, String tel, String cargo) throws Excessao {
        System.out.println(nome.isEmpty());
        System.out.println(id == 0);
        System.out.println(tel.isEmpty());
        System.out.println(cargo.isEmpty());

        if(nome.isEmpty() || id == 0 || tel.isEmpty() || cargo.isEmpty()){
            AlertaGeralUI alertaGeralUI = new AlertaGeralUI("Error ao cadastrar funcioário!");
            alertaGeralUI.setVisible(true);
            throw new Excessao("\"Error ao cadastrar funcioário!\"");
        }
    }

    private void salvaFuncionario(Funcionario newFuncionario){
        this.mainUI.getFuncionarios().add(newFuncionario);
        AlertaSucessoUI sucessoAlert = new AlertaSucessoUI();
        sucessoAlert.setVisible(true);
    }

}
