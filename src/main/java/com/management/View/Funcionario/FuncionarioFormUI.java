package com.management.View.Funcionario;

import com.management.Controller.EquipeController;
import com.management.Model.Classes.Equipe;
import com.management.Model.Classes.Excessao;
import com.management.Model.Classes.Funcionario;
import com.management.View.Alerts.AlertaGeralUI;
import com.management.Controller.FuncionarioController;
import com.management.View.PrincipalUI;
import com.management.utils.EncryptPassword;
import com.management.utils.Uuid;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

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
    private JComboBox<Equipe> cbEquipes;
    private PrincipalUI mainUI;
    private ArrayList<Funcionario> funcionarios;
    private Excessao excessao;
    private FuncionarioController funcionarioController = new FuncionarioController();
    private Uuid uuidLocal;
    private EquipeController equipeController = new EquipeController();

// Construtor
    public FuncionarioFormUI(PrincipalUI principalUIParam) throws SQLException, ClassNotFoundException {
        this.mainUI = principalUIParam;
        this.funcionarios = new ArrayList<Funcionario>();
        this.uuidLocal = new Uuid();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(300, 300));
//        mainPanel.repaint();
        this.setContentPane(mainPanel);
        this.pack();

        for (Equipe umaEquipe: this.equipeController.getEquipes()){
            cbEquipes.addItem(umaEquipe);
        }

        confirmarButton.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                String nextid = uuidLocal.generateId();
                String nome = tfNomeFuncionario.getText();
                String telefone = tftelefoneFuncionario.getText();
                String cargo = tfCargoFuncionario.getText();
                String email = tfemail.getText();
                String password = tfpassword.getText();
                Equipe selectedEquipe = cbEquipes.getItemAt(cbEquipes.getSelectedIndex());

                EncryptPassword encryptPassword = new EncryptPassword();
                String encryptedPassword = encryptPassword.encrypt(password);

                Funcionario newFuncionario = new Funcionario(nome, email,  nextid, telefone, cargo, "Ativo", "", encryptedPassword);

                try {
                    salvaFuncionario(newFuncionario);
                    adicionarFuncionaroEquipe(nextid, selectedEquipe);

                } catch (Exception ex) {
                    String log = ex.getMessage();
                    System.out.println(log);
                }

            }
        });
    }

    private void salvaFuncionario(Funcionario newFuncionario){
        try {
            this.funcionarioController.salvarDadosFuncionario(newFuncionario);
            this.mainUI.getFuncionarios().add(newFuncionario);
            JOptionPane.showMessageDialog(this.mainPanel, "Funcionario cadastrado com successo!");

        }catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(this.mainPanel, "Erro ao adicionar funcionario!");
        }
    }

    private void adicionarFuncionaroEquipe(String nextid, Equipe selectedEquipe) {
        try{
            this.funcionarioController.addFuncionarioEquipe(nextid, selectedEquipe.getIdEquipe());
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
