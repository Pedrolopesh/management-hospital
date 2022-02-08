package com.management.View.Funcionario;

import com.management.Model.Classes.Excessao;
import com.management.Model.Classes.Funcionario;
import com.management.View.Alerts.AlertaGeralUI;
import com.management.Controller.FuncionarioController;
import com.management.View.PrincipalUI;
import com.management.utils.EncryptPassword;
import lombok.SneakyThrows;

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
    private JTextField tfpassword;
    private JTextField tfemail;
    private PrincipalUI mainUI;
    private ArrayList<Funcionario> funcionarios;
    private Excessao excessao;
    private FuncionarioController funcionarioController;


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
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                int nextid = generateId();
                String nome = tfNomeFuncionario.getText();
                String telefone = tftelefoneFuncionario.getText();
                String cargo = tfCargoFuncionario.getText();
                String email = tfemail.getText();
                String password = tfpassword.getText();

                EncryptPassword encryptPassword = new EncryptPassword();
                String encryptedPassword = encryptPassword.encrypt(password);

                Funcionario newFuncionario = new Funcionario(nome, email,  nextid, telefone, "", "", "", encryptedPassword);

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
        FuncionarioController funcionarioController = new FuncionarioController();
        int nextid = funcionarioController.checkIdBeforeAdd() + 1;
        return nextid;
    }

    private void checkInputEntries(String nome, int id, String tel, String cargo) throws Excessao {
        System.out.println(nome.isEmpty());
        System.out.println(id == 0);
        System.out.println(tel.isEmpty());
        System.out.println(cargo.isEmpty());

        if(nome.isEmpty() || id == 0 || tel.isEmpty() || cargo.isEmpty()){

        }
    }

    private void salvaFuncionario(Funcionario newFuncionario){
        FuncionarioController funcionarioController = new FuncionarioController();
        funcionarioController.salvarDadosFuncionario(newFuncionario);
//        try{
//            boolean idResult =  funcionarioController.checkIdBeforeAdd(newFuncionario.getId());
//            if(idResult){
//            }else{
//                int newId = newFuncionario.getId()+1;
//                Funcionario newFuncionarioId = new Funcionario(newFuncionario.getNome(), newFuncionario.getEmail(), newId, newFuncionario.getTelefone(), newFuncionario.getCargo(), newFuncionario.getStatusFuncionario(), newFuncionario.getPacientesAtendidos(),newFuncionario.getPassword());
//                funcionarioController.salvarDadosFuncionario(newFuncionarioId);
//            }
//        }catch (Exception e){
//            System.out.println(e);
//        }


        this.mainUI.getFuncionarios().add(newFuncionario);
    }

}
