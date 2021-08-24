package com.management.UI;

import com.management.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FuncionarioFormUI extends JFrame {
    private JPanel mainPanel;
    private JTextField tfNomeFuncionario;
    private JTextField tftelefoneFuncionario;
    private JLabel cargoFuncionario;
    private JLabel lbNomeFuncionario;
    private JLabel lbTelefoneFuncionario;
    private JTextField cargoFuncionarioTextField;
    private JButton confirmarButton;
    private PrincipalUI sistemaPrincipalUI;
    private ArrayList<Funcionario> funcionarios;

    public FuncionarioFormUI(PrincipalUI principalUIParam){
        this.sistemaPrincipalUI = principalUIParam;
        this.funcionarios = new ArrayList<Funcionario>();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                int nextid = 0;
//                System.out.println("Funciona até agora ?");
//                for (Funcionario umFuncionario : funcionarios){
//                    if(funcionarios.size() == 0){
//                        nextid++;
//                    }else{
//                        nextid = funcionarios.size() + 1;
//                    }
//                    //TODO
//                    //não funciona ainda pois precisa cadastrar funcionários
//                    System.out.println("Ultimo id:" + funcionarios.size());
//                    System.out.println(umFuncionario.getId());
//                }
//                System.out.println(nextid);
                String nome = tfNomeFuncionario.getText();
                String telefone = tftelefoneFuncionario.getText();

                Funcionario newFuncionario = new Funcionario(nome, 1, telefone);
                salvaFuncionario(newFuncionario);
//                principalUI.getFuncionarios().add(newFuncionario);

            }
        });
    }

    private void salvaFuncionario(Funcionario newFuncionario) {
        this.sistemaPrincipalUI.getFuncionarios().add(newFuncionario);
    }

//    public static void main(String[] args){
//        JFrame frame = new FuncionarioFormUI();
//        frame.setVisible(true);
//    }
}
