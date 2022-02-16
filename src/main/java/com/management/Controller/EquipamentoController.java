package com.management.Controller;

import com.management.Model.Classes.Equipamento;
import com.management.Model.Classes.Especialidade;

import java.sql.*;
import java.util.ArrayList;

public class EquipamentoController {

    public void salvarDadosEquipamento(Equipamento newEquipamento) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

            String id = newEquipamento.getIdEquipamento();
            String nomeEquipamento = newEquipamento.getNomeEquipamento();
            int quantEquipamento = newEquipamento.getQntEquipamento();

            PreparedStatement ps = conn.prepareStatement(
                    "insert into equipamentos " +
                            "(idequipamento, nomeEquipamento, qntEquipamento ) values (?, ?, ?)"
            );

            ps.setString(1, id);
            ps.setString(2, nomeEquipamento);
            ps.setInt(3, quantEquipamento);

            ps.executeUpdate();
            ps.closeOnCompletion();

        } catch (SQLException throwables) {
            System.out.println("SQLException");
            throwables.printStackTrace();

        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("classNotFoundException");
            classNotFoundException.printStackTrace();
        }
    }

    public ArrayList<Equipamento> getEquipamentos() throws ClassNotFoundException, SQLException {
        ArrayList<Equipamento> equipamentosList = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from equipamentos");

        Equipamento equipamento;

        while(rs.next()){
            equipamento = new Equipamento(rs.getString("nomeEquipamento"), rs.getInt("qntEquipamento"), rs.getString("qntEquipamento"));

            equipamentosList.add(equipamento);
        }

        return equipamentosList;
    }
}
