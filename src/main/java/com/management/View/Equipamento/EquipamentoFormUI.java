package com.management.View.Equipamento;

import com.management.Model.Classes.Equipamento;
import com.management.View.PrincipalUI;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;

public class EquipamentoFormUI extends JFrame {
    private JPanel mainPanel;
    private JTextField txNomeEquipamento;
    private JTextField txNumeroEquipamentos;
    private JButton btnConfirmar;
    private PrincipalUI mainUI;
    private ArrayList<Equipamento>equipamentos;

    public EquipamentoFormUI (PrincipalUI principalUI){
        this.mainUI = principalUI;
        this.equipamentos = new ArrayList<Equipamento>();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(300, 300));
        this.setContentPane(mainPanel);
        this.pack();

        btnConfirmar.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                int nextid = generateId();
                String NomeEquipamento = txNomeEquipamento.getText();
                int NumeroEquipamentos = Integer.parseInt(txNumeroEquipamentos.getText());

                trySaveIntoDb(nextid, NomeEquipamento, NumeroEquipamentos);

                Equipamento exemploEquipamento = new Equipamento("Respirador",1,nextid);
                Equipamento novoEquipamento = new Equipamento(NomeEquipamento,NumeroEquipamentos,nextid);
                salvarEquipamento(novoEquipamento);
            }
        });
    }
    private int generateId(){
        int nextid = this.mainUI.getFuncionarios().size() + 1;;
        return nextid;
    }

    private void trySaveIntoDb(int nextid, String NomeEquipamentoParam, int qntEquipamentoParam) throws ClassNotFoundException, SQLException {

        int idequipamento = generateId();
        String nomeEquipamento = NomeEquipamentoParam;
        int qntEquipamento = qntEquipamentoParam;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");
            Statement stmt = conn.createStatement();

            PreparedStatement ps = conn.prepareStatement("insert into equipamento(idequipamento,nomeEquipamento,qntEquipamento) values (?, ?, ?)");
            ps.setInt(1, idequipamento);
            ps.setString(2, nomeEquipamento);
            ps.setInt(3, qntEquipamento);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Insert Sucessfully");

            ResultSet rs = stmt.executeQuery("select idequipamento, nomeEquipamento, qntEquipamento from equipamento;");
            System.out.println(rs);

        } catch (Exception e){
            System.out.println(e);
        }
    }

    private void salvarEquipamento(Equipamento novoEquipamento) {
        this.mainUI.getEquipamentos().add(novoEquipamento);
    }
}
